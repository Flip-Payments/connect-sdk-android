package com.flip.connect.presentation.login;

import android.content.Context;

import com.flip.connect.Connect;
import com.flip.connect.data.dependencies.TokenType;
import com.flip.connect.data.repository.local.LocalDataManager;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.OauthToken;
import com.flip.connect.domain.repository.LocalRepository;
import com.flip.connect.domain.usecase.OauthAccessUseCase;
import com.flip.connect.presentation.base.BasePresenter;

import java.util.UUID;

import br.com.rexlab.fplib.FingerPrintLibrary;

/**
 * Created by jcosilva on 6/9/2017.
 */

class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private OauthAccessUseCase useCase;
    private LocalRepository localManager;
    private Context context;

    LoginPresenter(Context context) {
        this.context = context;
        useCase = new OauthAccessUseCase();
        localManager = new LocalDataManager(context);
    }

    @Override
    public void loadCredentials(String authCode) {
        useCase.requestToken(authCode, new CallbackBoundary<OauthToken>() {
            @Override
            public void success(OauthToken response) {
                localManager.saveOauth(response, TokenType.ACCESS_TOKEN);
                //region Fingerprint
                String uniqueId = UUID.randomUUID().toString();
                Connect.getInstance().setUniqueId(uniqueId);
                FingerPrintLibrary.initFingerprint(context, "sandbox",
                        "d82436c6-3664-467f-80eb-739017d13b1a", response.getAccountKey().toString(),
                        uniqueId);
                FingerPrintLibrary.configFingerprint(true, true, true, true, true, true);
                FingerPrintLibrary.getFingerprint();
                //endregion
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
