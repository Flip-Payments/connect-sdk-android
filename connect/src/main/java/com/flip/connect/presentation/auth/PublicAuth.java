package com.flip.connect.presentation.auth;

import android.content.Context;

import com.flip.connect.data.dependencies.TokenType;
import com.flip.connect.data.repository.local.LocalDataManager;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.auth.OauthToken;
import com.flip.connect.domain.repository.LocalRepository;
import com.flip.connect.domain.usecase.PublicOauthUseCase;

/**
 * Created by Kanda on 10/07/2017.
 */

public class PublicAuth {
    private LocalRepository localManager;
    private PublicOauthUseCase publicOauthUseCase;
    private OauthToken token;

    public PublicAuth(Context context) {
        publicOauthUseCase = new PublicOauthUseCase();
        localManager = new LocalDataManager(context);
    }

    public void requestPublicOauth(final CallbackBoundary callbackBoundary) {
        publicOauthUseCase = new PublicOauthUseCase();
        publicOauthUseCase.requestPublicToken(new CallbackBoundary() {
            @Override
            public void success(Object response) {
                localManager.saveOauth((OauthToken) response, TokenType.PUBLIC_TOKEN);
                callbackBoundary.success(response);
            }

            @Override
            public void error(Throwable e) {
                callbackBoundary.error(e);
            }
        });
    }
}
