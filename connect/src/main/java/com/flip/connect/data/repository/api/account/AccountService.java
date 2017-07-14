package com.flip.connect.data.repository.api.account;

import com.flip.connect.domain.model.account.Account;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Kanda on 13/07/2017.
 */

public interface AccountService {

    @GET
    public Call<Account> getAccount();

}
