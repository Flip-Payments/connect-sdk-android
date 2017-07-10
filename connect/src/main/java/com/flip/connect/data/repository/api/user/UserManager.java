package com.flip.connect.data.repository.api.user;

import com.flip.connect.data.dependencies.NetworkDependencies;
import com.flip.connect.data.repository.api.BaseManager;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.repository.UserRepository;

/**
 * Created by Kanda on 10/07/2017.
 */

public class UserManager extends BaseManager implements UserRepository {

    private UserService service;

    public UserManager() {
        service = NetworkDependencies.retrofit().create(UserService.class);
    }

    @Override
    public void getUser(String accountKey, CallbackBoundary callbackBoundary) {
        super.callbackBoundary(callbackBoundary);
        service.getUser(accountKey).enqueue(this);
    }

}
