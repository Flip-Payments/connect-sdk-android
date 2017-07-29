package com.flip.connect.domain.repository;

import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.auth.OauthToken;
import com.flip.connect.domain.model.user.UserResponse;

/**
 * Created by Kanda on 10/07/2017.
 */

public interface PublicDataRepository {

    void getUser(OauthToken token, CallbackBoundary<UserResponse> callbackBoundary);
}
