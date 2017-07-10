package com.flip.connect.domain.usecase;

import com.flip.connect.domain.boundary.CallbackBoundary;

/**
 * Created by Kanda on 10/07/2017.
 */

public class PublicOauthUseCase extends BaseUseCase {

    public PublicOauthUseCase() {
        super();
    }

    public void requestPublicToken(CallbackBoundary callbackBoundary) {
        this.callbackBoundary = callbackBoundary;
        options.put(Options.GRANT_TYPE.toString(), Method.CLIENT_CREDENTIALS.name());
        request();
    }

}
