package com.flip.connect.presentation.auth;

import android.content.Context;
import android.util.Log;

import com.flip.connect.data.repository.local.LocalDataManager;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.OauthToken;
import com.flip.connect.domain.repository.LocalRepository;
import com.flip.connect.domain.usecase.OauthUseCase;

/**
 * Created by jcosilva on 6/9/2017.
 */

public class ConnectAuth {

    private LocalRepository localManager;
    private OauthUseCase useCase;
    private OauthToken token;

    public ConnectAuth(Context context) {
        localManager = new LocalDataManager(context);
        useCase = new OauthUseCase();
        token = localManager.getOauth();
    }

    public void refreshToken(CallbackBoundary callbackBoundary) {
        useCase.refreshToken(token, callbackBoundary);
    }

    public void verifyToken(CallbackBoundary callbackBoundary) {
        useCase.verifyToken(token, callbackBoundary);
    }

}
