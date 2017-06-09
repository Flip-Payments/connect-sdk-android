package com.flip.connect.data.repository.api;

import com.flip.connect.data.dependencies.NetworkDependencies;
import com.flip.connect.data.model.OauthToken;
import com.flip.connect.domain.repository.AuthRepository;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jcosilva on 6/8/2017.
 */

public class AuthManager implements AuthRepository {
    @Override
    public void authRefreshToken(Map<String, String> options) {
        AuthService service = NetworkDependencies.retrofit().create(AuthService.class);
        service.requestAccessToken(options).enqueue(new Callback<OauthToken>() {
            @Override
            public void onResponse(Call<OauthToken> call, Response<OauthToken> response) {

            }

            @Override
            public void onFailure(Call<OauthToken> call, Throwable t) {

            }
        });
    }
}
