package com.flip.connect.data.repository.api.account;

import com.flip.connect.data.model.UpdateModel;
import com.flip.connect.domain.model.account.AccountModel;
import com.flip.connect.domain.model.BaseResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;

/**
 * Created by Kanda on 13/07/2017.
 */

public interface AccountService {

    @Headers({
            "Accept-Language: pt-BR",
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET("/user/account")
    Call<AccountModel> getAccount(@Header("Authorization") String authorization);

    @PATCH("/user/account")
    Call<BaseResponse> updateAccount(@Header("Authorization") String authorization, @Body UpdateModel body);

}
