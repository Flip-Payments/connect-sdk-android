package com.flip.connect.data.repository.api.account;

import android.support.annotation.NonNull;

import com.flip.connect.Connect;
import com.flip.connect.data.dependencies.NetworkDependencies;
import com.flip.connect.data.model.tempProfile.TempProfile;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.account.AccountModel;
import com.flip.connect.domain.model.auth.OauthToken;
import com.flip.connect.domain.model.user.PendingProfile;
import com.flip.connect.domain.repository.AccountRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kanda on 13/07/2017.
 */

public class AccountManager implements AccountRepository {

    private AccountService service;

    public AccountManager() {
        service = NetworkDependencies.retrofit(Connect.getInstance().getPrivateApiUrl()).create(AccountService.class);
    }

    @Override
    public void getAccount(OauthToken token, final CallbackBoundary<AccountModel> callbackBoundary) {
        service.getAccount("bearer " + token.getAccessToken()).enqueue(new Callback<AccountModel>() {
            @Override
            public void onResponse(@NonNull Call<AccountModel> call, @NonNull Response<AccountModel> response) {
                if (response.isSuccessful() && response.body().hasSuccess())
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
    public void savePendingProfile(String clientID, TempProfile body, final CallbackBoundary<PendingProfile> callbackBoundary) {
        body.setApplicationKey(clientID);
        service.savePendingProfile(body).enqueue(new Callback<PendingProfile>(){
            @Override
            public void onResponse(@NonNull Call<PendingProfile> call, @NonNull Response<PendingProfile> response) {
                if (response.isSuccessful() && response.body().hasSuccess())
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
