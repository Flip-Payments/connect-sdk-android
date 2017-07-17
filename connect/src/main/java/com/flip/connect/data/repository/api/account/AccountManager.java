package com.flip.connect.data.repository.api.account;

import android.support.annotation.NonNull;

import com.flip.connect.BuildConfig;
import com.flip.connect.data.dependencies.NetworkDependencies;
import com.flip.connect.data.model.account.AccountResponse;
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
    public void getAccount(OauthToken token, final CallbackBoundary<AccountResponse> callbackBoundary) {
        service.getAccount("bearer "+token.getAccessToken()).enqueue(new Callback<AccountResponse>() {
            @Override
            public void onResponse(@NonNull Call<AccountResponse> call, @NonNull Response<AccountResponse> response) {
                callbackBoundary.success(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<AccountResponse> call, @NonNull Throwable t) {
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
