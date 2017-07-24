package com.flip.connect.presentation.views.login;

import android.content.Context;
import android.util.Log;

import com.flip.connect.domain.entities.TokenType;
import com.flip.connect.Connect;
import com.flip.connect.data.repository.local.LocalDataManager;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.auth.OauthToken;
import com.flip.connect.domain.repository.LocalRepository;
import com.flip.connect.domain.usecase.auth.OauthAccessUseCase;
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
        Log.e("token","asdfasdas");
    }

    @Override
    public void loadCredentials(String authCode) {
        useCase.requestToken(authCode, new CallbackBoundary<OauthToken>() {
            @Override
            public void success(OauthToken response) {
                Log.e("token",response.toString());
                localManager.saveOauth(response, TokenType.ACCESS_TOKEN);
                //region Fingerprint
                String uniqueId = UUID.randomUUID().toString();
                Connect.getInstance().setUniqueId(uniqueId);
                FingerPrintLibrary.initFingerprint(context, "sandbox",
                        "d82436c6-3664-467f-80eb-739017d13b1a", response.getUserKey(),
                        uniqueId);
                Log.e("UNIQUE ID", Connect.getInstance().getUniqueId());
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
