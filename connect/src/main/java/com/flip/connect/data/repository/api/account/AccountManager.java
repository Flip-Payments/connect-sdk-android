package com.flip.connect.data.repository.api.account;

import android.support.annotation.NonNull;

import com.flip.connect.BuildConfig;
import com.flip.connect.data.dependencies.NetworkDependencies;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.account.Account;
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
        service = NetworkDependencies.retrofit(BuildConfig.PUBLIC_API).create(AccountService.class);
    }

    @Override
    public void getAccount(final CallbackBoundary<Account> callbackBoundary) {
        service.getAccount("Bearer 4C9E9B38C3EF63AD5AF250611248C226").enqueue(new Callback<Account>() {
            @Override
            public void onResponse(@NonNull Call<Account> call, @NonNull Response<Account> response) {
                callbackBoundary.success(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<Account> call, @NonNull Throwable t) {

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
