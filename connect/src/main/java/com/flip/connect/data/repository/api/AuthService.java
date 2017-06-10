package com.flip.connect.data.repository.api;

import com.flip.connect.domain.model.OauthToken;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by jcosilva on 6/8/2017.
 */

public interface AuthService {

    @POST("/api/oauth/token")
    Call<OauthToken> requestAccessToken(@QueryMap Map<String, String> options);

// @POST("http://dlp-qrservices.cloudapp.net:20112/api/oauth/token?clientId=F7F667C7-199F-4A10-B53A-4FADCDFADB53&redirectUri=ipiranga://ipiranga&authorizationCode=2a7406c9-9c0c-4547-b5cd-624297c3c777&grantType=authorization_code")
//?grantType=authorization_code&authorizationCode=03f59259-8d11-4844-b0e8-bfc3ecf56162&redirectUri=ipirangaConnect://authorize
}
