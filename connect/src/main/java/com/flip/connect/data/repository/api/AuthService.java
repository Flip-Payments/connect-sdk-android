package com.flip.connect.data.repository.api;

import com.flip.connect.data.model.OauthToken;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by jcosilva on 6/8/2017.
 */

public interface AuthService {

    @POST("//api/oauth/token")
    Call<OauthToken> requestAccessToken(@QueryMap Map<String, String> options);

//?grantType=authorization_code&authorizationCode=03f59259-8d11-4844-b0e8-bfc3ecf56162&redirectUri=ipirangaConnect://authorize
}
