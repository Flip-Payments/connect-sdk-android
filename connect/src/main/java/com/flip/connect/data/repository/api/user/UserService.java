package com.flip.connect.data.repository.api.user;

import com.flip.connect.domain.model.user.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Kanda on 10/07/2017.
 */

public interface UserService {

    @GET("/public/users/{accountKey}")
    Call<User> getUser(@Path("accountKey") String accountKey);

}
