package com.flip.connect.data.repository.api.account;

import com.flip.connect.data.model.UpdateModel;
import com.flip.connect.data.model.account.AccountModel;

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

    @PATCH("/user/account/personaldata")
    Call<UpdateModel> updatePersonalData(@Header("Authorization") String authorization, @Body UpdateModel body);

    @PATCH("/user/account/publicprofile")
    Call<UpdateModel> updatePublicProfile(@Header("Authorization") String authorization);

}
