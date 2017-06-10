package com.flip.connect.presentation.login;

import com.flip.connect.domain.model.OauthToken;
import com.flip.connect.presentation.base.BasePresenterContract;
import com.flip.connect.presentation.base.BaseViewContract;

/**
 * Created by jcosilva on 6/9/2017.
 */

interface LoginContract {

    interface View extends BaseViewContract {
        void loginWithSuccess(OauthToken token);

        void loginFailed(Throwable t);
    }

    interface Presenter extends BasePresenterContract<View> {
        void loadCredentials(String authCode);
    }
}
