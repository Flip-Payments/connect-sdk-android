package com.flip.connect.data.repository.api.user;

import com.flip.connect.BuildConfig;
import com.flip.connect.Connect;
import com.flip.connect.data.dependencies.NetworkDependencies;
import com.flip.connect.data.repository.api.BaseManager;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.auth.OauthToken;
import com.flip.connect.domain.model.user.User;
import com.flip.connect.domain.model.user.UserResponse;
import com.flip.connect.domain.repository.UserRepository;

/**
 * Created by Kanda on 10/07/2017.
 */

public class UserManager extends BaseManager implements UserRepository {

    private UserService service;

    public UserManager() {
        service = NetworkDependencies.retrofit(BuildConfig.PUBLIC_API).create(UserService.class);
    }

    @Override
    public void getUser(OauthToken token,CallbackBoundary<UserResponse> callbackBoundary) {
        super.callbackBoundary(callbackBoundary);
        service.getUser("Bearer "+Connect.getInstance().getPublicToken(),token.getAccountKey()).enqueue(this);
    }

}
