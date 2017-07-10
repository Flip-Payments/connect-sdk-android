package com.flip.connect.domain.usecase;

import com.flip.connect.Connect;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.OauthToken;

/**
 * Created by jcosilva on 6/9/2017.
 */

public class OauthAccessUseCase extends BaseUseCase {

    public OauthAccessUseCase() {
        super();
        options.put("redirectUri", Connect.getInstance().getSchema() + "://" + Connect.getInstance().getHost());
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
