package com.flip.connect.presentation.auth;

import android.content.Context;

import com.flip.connect.data.dependencies.TokenType;
import com.flip.connect.data.repository.local.LocalDataManager;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.auth.OauthToken;
import com.flip.connect.domain.repository.LocalRepository;
import com.flip.connect.domain.usecase.auth.OauthAccessUseCase;

/**
 * Created by jcosilva on 6/9/2017.
 */

public class ConnectAuth {

    private LocalRepository localManager;
    private OauthAccessUseCase useCase;
    private OauthToken token;

    public ConnectAuth(Context context) {
        localManager = new LocalDataManager(context);
        useCase = new OauthAccessUseCase();
        token = localManager.getOauth(TokenType.ACCESS_TOKEN);
    }

    public void refreshToken(CallbackBoundary callbackBoundary) {
        if (token == null) {
            callbackBoundary.error(new Throwable("Token not found"));
        } else {
            useCase.refreshToken(token, callbackBoundary);
        }
    }

    public void verifyToken(CallbackBoundary callbackBoundary) {
        if (token == null) {
            callbackBoundary.error(new Throwable("Token not found"));
        } else {
            useCase.verifyToken(token, callbackBoundary);
        }
    }

}
