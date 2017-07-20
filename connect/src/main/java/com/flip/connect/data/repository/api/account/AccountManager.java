package com.flip.connect.data.repository.api.account;

import android.support.annotation.NonNull;
import android.util.Log;

import com.flip.connect.BuildConfig;
import com.flip.connect.data.dependencies.NetworkDependencies;
import com.flip.connect.data.model.UpdateModel;
import com.flip.connect.data.model.account.AccountModel;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.BaseResponse;
import com.flip.connect.domain.model.auth.OauthToken;
import com.flip.connect.domain.repository.AccountRepository;
import com.google.gson.Gson;

import java.util.Locale;

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
        service.getAccount("bearer "+token.getAccessToken()).enqueue(new Callback<AccountModel>() {
            @Override
            public void onResponse(@NonNull Call<AccountModel> call, @NonNull Response<AccountModel> response) {
                if(response.isSuccessful() && response.body().getSuccess())
                    callbackBoundary.success(response.body());
                else
                    callbackBoundary.error(new Throwable(response.code() + " Error: " + response.message()));
            }

            @Override
            public void onFailure(@NonNull Call<AccountModel> call, @NonNull Throwable t) {
                callbackBoundary.error(t);
            }
        });
    }

    @Override
    public void updatePersonalData(OauthToken token, final UpdateModel update, final CallbackBoundary<BaseResponse> callbackBoundary) {
        service.updatePersonalData("bearer "+token.getAccessToken(), update).enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.e("ABUSO", new Gson().toJson(update));
                if(response.isSuccessful() && response.body().getSuccess())
                    callbackBoundary.success(response.body());
                else
                    callbackBoundary.error(new Throwable(response.body().toString()));
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                callbackBoundary.error(t);
            }
        });
    }

    @Override
    public void getAddress() {

    }

    @Override
    public void getDocuments() {

    }

    @Override
    public void getPersonalData() {

    }
}
