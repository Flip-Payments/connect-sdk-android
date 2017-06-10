package com.flip.connect.presentation.login;

import android.content.Context;

import com.flip.connect.data.repository.local.LocalDataManager;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.OauthToken;
import com.flip.connect.domain.repository.LocalRepository;
import com.flip.connect.domain.usecase.OauthUseCase;
import com.flip.connect.presentation.base.BasePresenter;

/**
 * Created by jcosilva on 6/9/2017.
 */

 class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private OauthUseCase useCase;
    private LocalRepository localManager;

     LoginPresenter(Context context) {
        useCase = new OauthUseCase();
        localManager = new LocalDataManager(context);
    }

    @Override
    public void loadCredentials(String authCode) {
        useCase.requestToken(authCode, new CallbackBoundary<OauthToken>() {
            @Override
            public void success(OauthToken response) {
                localManager.saveOauth(response);
                getView().loginWithSuccess(response);
            }

            @Override
            public void error(Throwable e) {

                e.printStackTrace();
                getView().loginFailed(e);
            }
        });

    }
}
