package com.flip.connect.data.repository.api.auth;

import com.flip.connect.BuildConfig;
import com.flip.connect.data.dependencies.NetworkDependencies;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.auth.OauthToken;
import com.flip.connect.domain.repository.AuthRepository;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jcosilva on 6/8/2017.
 */

public class AuthManager implements AuthRepository {

    private AuthService service;

    public AuthManager() {
        service = NetworkDependencies.retrofit(BuildConfig.API_BASE_URL).create(AuthService.class);
    }

    @Override
    public void authRequestToken(Map<String, String> options, final CallbackBoundary callbackBoundary) {
        service.requestAccessToken(options).enqueue(new Callback<OauthToken>() {
            @Override
            public void onResponse(Call<OauthToken> call, Response<OauthToken> response) {
                if (response.isSuccessful() && response.body().hasSuccess()) {
                    callbackBoundary.success(response.body());
                } else {
                    callbackBoundary.error(new Throwable(response.code() + " Error: " + response.message()));
                }
            }

            @Override
            public void onFailure(Call<OauthToken> call, Throwable t) {
                callbackBoundary.error(t);
            }
        });
    }

}
