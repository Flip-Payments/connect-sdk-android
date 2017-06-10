package com.flip.connect.domain.usecase;

import android.util.Log;

import com.flip.connect.Connect;
import com.flip.connect.data.repository.api.AuthManager;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.OauthToken;
import com.flip.connect.domain.repository.AuthRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jcosilva on 6/9/2017.
 */

public class OauthUseCase {

    private AuthRepository authManager;
    private Map<String, String> options;
    private CallbackBoundary callbackBoundary;

    public OauthUseCase() {
        this.options = new HashMap<>();
        authManager = new AuthManager();
        this.options.put("redirectUri", Connect.getInstance().getSchema() + "://" + Connect.getInstance().getHost());
        options.put("clientId", Connect.getInstance().getClientId());
        options.put("clientSecret", Connect.getInstance().getClientSecret());
    }


    private void request() {
        authManager.authRequestToken(options, callbackBoundary);
    }

    public void refreshToken(OauthToken token, CallbackBoundary callbackBoundary) {
        this.callbackBoundary = callbackBoundary;
        options.put("refreshToken", token.getRefreshToken());
        options.put("grantType", Method.REFRESH_TOKEN.name());
        authManager.authRequestToken(options, callbackBoundary);
        request();
    }

    public void verifyToken(OauthToken token, CallbackBoundary callbackBoundary) {
        this.callbackBoundary = callbackBoundary;
        options.put("accessToken", token.getAccessToken());
        options.put("grantType", Method.VERIFY_TOKEN.name());
        request();
    }

    public void requestToken(String authCode, CallbackBoundary callbackBoundary) {
        this.callbackBoundary = callbackBoundary;
        options.put("authorizationCode", authCode);
        options.put("grantType", Method.AUTHORIZATION_CODE.name());
        request();
    }

}
