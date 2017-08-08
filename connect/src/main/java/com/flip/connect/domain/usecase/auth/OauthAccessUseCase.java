package com.flip.connect.domain.usecase.auth;

import com.flip.connect.Connect;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.entities.Method;
import com.flip.connect.domain.entities.Options;
import com.flip.connect.domain.model.auth.OauthToken;
import com.flip.connect.domain.usecase.BaseUseCase;

/**
 * Created by jcosilva on 6/9/2017.
 */

public class OauthAccessUseCase extends BaseUseCase {
    public OauthAccessUseCase() {
        super();
        options.put(Options.REDIRECT_URI.toString(), Connect.getInstance().getSchema() + "://" + Connect.getInstance().getHost());
    }

    public void refreshToken(OauthToken token, CallbackBoundary callbackBoundary) {
        this.callbackBoundary = callbackBoundary;
        options.put(Options.REFRESH_TOKEN.toString(), token.getRefreshToken());
        options.put(Options.GRANT_TYPE.toString(), Method.REFRESH_TOKEN.name());
        authManager.authRequestToken(options, callbackBoundary);
        request();
    }

    public void verifyToken(OauthToken token, CallbackBoundary callbackBoundary) {
        this.callbackBoundary = callbackBoundary;
        options.put(Options.ACCESS_TOKEN.toString(), token.getAccessToken());
        options.put(Options.GRANT_TYPE.toString(), Method.VERIFY_TOKEN.name());
        request();
    }

    public void requestToken(String authCode, CallbackBoundary callbackBoundary) {
        this.callbackBoundary = callbackBoundary;
        options.put(Options.AUTHORIZATION_CODE.toString(), authCode);
        options.put(Options.GRANT_TYPE.toString(), Method.AUTHORIZATION_CODE.name());
        request();
    }


}
