package com.flip.connect.presentation.views.login;

import android.content.Context;
import android.util.Log;

import com.flip.connect.Connect;
import com.flip.connect.data.model.tempProfile.TempProfile;
import com.flip.connect.data.repository.local.LocalDataManager;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.entities.TokenType;
import com.flip.connect.domain.model.auth.OauthToken;
import com.flip.connect.domain.model.user.PendingProfile;
import com.flip.connect.domain.repository.LocalRepository;
import com.flip.connect.domain.usecase.account.AccountUseCase;
import com.flip.connect.domain.usecase.auth.OauthAccessUseCase;
import com.flip.connect.presentation.base.BasePresenter;
import com.flip.connect.presentation.manager.FingerPrintManager;

/**
 * Created by jcosilva on 6/9/2017.
 */

class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private OauthAccessUseCase oauthAccessUseCase;
    private AccountUseCase accountUseCase;
    private LocalRepository localManager;
    private Context context;

    LoginPresenter(Context context) {
        this.context = context;
        oauthAccessUseCase = new OauthAccessUseCase();
        accountUseCase = new AccountUseCase();
        localManager = new LocalDataManager(context);
    }

    @Override
    public void loadCredentials(String authCode) {
        oauthAccessUseCase.requestToken(authCode, new CallbackBoundary<OauthToken>() {
            @Override
            public void success(OauthToken response) {
                localManager.saveOauth(response, TokenType.ACCESS_TOKEN);
                FingerPrintManager.sendFingerPrint(context, response);
                getView().loginWithSuccess(response);
            }

            @Override
            public void error(Throwable e) {
                e.printStackTrace();
                getView().loginFailed(e);
            }
        });
    }

    @Override
    public void savePendingProfile(TempProfile pendingProfile) {
        accountUseCase.savePendingProfile(pendingProfile, new CallbackBoundary<PendingProfile>() {
            @Override
            public void success(PendingProfile response) {
                Connect.getInstance().setDataKey(response.getDataKey());
                getView().goToWebView();
            }

            @Override
            public void error(Throwable e) {
                getView().goToWebView();
            }
        });
    }
}
