package com.flip.connect.data.repository.api.account;

import android.support.annotation.NonNull;
import android.util.Log;

import com.flip.connect.BuildConfig;
import com.flip.connect.data.dependencies.NetworkDependencies;
import com.flip.connect.data.model.UpdateModel;
import com.flip.connect.data.model.account.AccountModel;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.auth.OauthToken;
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
        service = NetworkDependencies.retrofit(BuildConfig.PRIVATE_API).create(AccountService.class);
    }

    @Override
    public void getAccount(OauthToken token, final CallbackBoundary<AccountModel> callbackBoundary) {
        service.getAccount("bearer "+token.getAccessToken()).enqueue(new Callback<AccountModel>() {
            @Override
            public void onResponse(@NonNull Call<AccountModel> call, @NonNull Response<AccountModel> response) {
                callbackBoundary.success(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<AccountModel> call, @NonNull Throwable t) {
                callbackBoundary.error(t);
            }
        });
    }

    @Override
    public void setAccount(OauthToken token, final CallbackBoundary<UpdateModel> callbackBoundary, UpdateModel account) {
        service.updatePersonalData("bearer "+token.getAccessToken(), account).enqueue(new Callback<UpdateModel>() {
            @Override
            public void onResponse(Call<UpdateModel> call, Response<UpdateModel> response) {
                callbackBoundary.success(response.body());
            }

            @Override
            public void onFailure(Call<UpdateModel> call, Throwable t) {
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
