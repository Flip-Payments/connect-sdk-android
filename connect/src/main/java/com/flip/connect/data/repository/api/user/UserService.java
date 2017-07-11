package com.flip.connect.data.repository.api.user;

import com.flip.connect.domain.model.user.User;
import com.flip.connect.domain.model.user.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by Kanda on 10/07/2017.
 */

public interface UserService {

    @Headers({
            "Accept-Language: pt-BR",
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @GET("/public/users/{accountKey}")
    Call<UserResponse> getUser(@Header("Authorization") String authorization, @Path("accountKey") String accountKey);

}
