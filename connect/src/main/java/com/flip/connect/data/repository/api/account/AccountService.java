package com.flip.connect.data.repository.api.account;

import com.flip.connect.data.model.tempProfile.TempProfile;
import com.flip.connect.domain.model.BaseResponse;
import com.flip.connect.domain.model.account.AccountModel;
import com.flip.connect.domain.model.user.PendingProfile;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

/**
 * Created by Kanda on 13/07/2017.
 */

public interface AccountService {

    @Headers({
            "Accept-Language: pt-BR",
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET("/user/account?include=documents&include=addresses&include=emails&include=personaldata&include=phones")
    Call<AccountModel> getAccount(@Header("Authorization") String authorization);

    @PATCH("/user/account")
    Call<BaseResponse> update(@Header("Authorization") String authorization, @Body JsonObject body);

    @POST("/user/temporaryProfile")
    Call<PendingProfile> savePendingProfile(@Body TempProfile body);

}
