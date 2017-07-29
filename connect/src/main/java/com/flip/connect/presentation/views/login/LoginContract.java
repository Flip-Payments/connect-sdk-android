package com.flip.connect.presentation.views.login;

import com.flip.connect.data.model.TempProfile;
import com.flip.connect.domain.model.auth.OauthToken;
import com.flip.connect.presentation.base.BasePresenterContract;
import com.flip.connect.presentation.base.BaseViewContract;

/**
 * Created by jcosilva on 6/9/2017.
 */

interface LoginContract {

    interface View extends BaseViewContract {
        void loginWithSuccess(OauthToken token);

        void loginFailed(Throwable t);

        void goToWebView();
    }

    interface Presenter extends BasePresenterContract<View> {
        void loadCredentials(String authCode);
        void savePendingProfile(TempProfile pendingProfile);
    }
}
