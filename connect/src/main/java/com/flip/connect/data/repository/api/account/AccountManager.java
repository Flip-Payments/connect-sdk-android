package com.flip.connect.data.repository.api.account;

import android.support.annotation.NonNull;

import com.flip.connect.BuildConfig;
import com.flip.connect.data.dependencies.NetworkDependencies;
import com.flip.connect.data.model.TempProfile;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.BaseResponse;
import com.flip.connect.domain.model.account.AccountModel;
import com.flip.connect.domain.model.auth.OauthToken;
import com.flip.connect.domain.model.user.PendingProfile;
import com.flip.connect.domain.repository.AccountRepository;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kanda on 13/07/2017.
 */

public class AccountManager implements AccountRepository {

    private AccountService service;

    public AccountManager() {
        service = NetworkDependencies.retrofit(BuildConfig.PRIVATE_API).create(AccountService.class);
    }

    @Override
    public void getAccount(OauthToken token, final CallbackBoundary<AccountModel> callbackBoundary) {
        service.getAccount("bearer " + token.getAccessToken()).enqueue(new Callback<AccountModel>() {
            @Override
            public void onResponse(@NonNull Call<AccountModel> call, @NonNull Response<AccountModel> response) {
                if (response.isSuccessful() && response.body().getSuccess())
                    callbackBoundary.success(response.body());
                else if (response.body() == null) {
                    callbackBoundary.error(new Throwable("Unknow error"));
                } else
                    callbackBoundary.error(new Throwable(response.body().toString()));
            }

            @Override
            public void onFailure(@NonNull Call<AccountModel> call, @NonNull Throwable t) {
                callbackBoundary.error(t);
            }
        });
    }

    @Override
    public void update(OauthToken token, final JsonObject update, final CallbackBoundary<BaseResponse> callbackBoundary) {
        service.update("bearer " + token.getAccessToken(), update).enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse> call, @NonNull Response<BaseResponse> response) {
                if (response.isSuccessful() && response.body().getSuccess())
                    callbackBoundary.success(response.body());
                else if (response.body() == null) {
                    callbackBoundary.error(new Throwable("Unknow error"));
                } else
                    callbackBoundary.error(new Throwable(response.body().toString()));
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse> call, @NonNull Throwable t) {
                callbackBoundary.error(t);
            }
        });
    }

    @Override
    public void savePendingProfile(String clientID, TempProfile body, final CallbackBoundary<PendingProfile> callbackBoundary) {
        body.setApplicationKey(clientID);
        service.savePendingProfile(body).enqueue(new Callback<PendingProfile>(){
            @Override
            public void onResponse(@NonNull Call<PendingProfile> call, @NonNull Response<PendingProfile> response) {
                if (response.isSuccessful() && response.body().getSuccess())
                    callbackBoundary.success(response.body());
                else if (response.body() == null) {
                    callbackBoundary.error(new Throwable("Unknow error"));
                } else
                    callbackBoundary.error(new Throwable(response.body().toString()));
            }

            @Override
            public void onFailure(@NonNull Call<PendingProfile> call, Throwable t) {
                callbackBoundary.error(t);
            }
        });
    }
}
