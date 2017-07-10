package com.flip.connect.domain.usecase;

import com.flip.connect.Connect;
import com.flip.connect.data.repository.api.AuthManager;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.repository.AuthRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jcosilva on 10/07/2017.
 */

abstract class BaseUseCase {
    AuthRepository authManager;
    Map<String, String> options;
    CallbackBoundary callbackBoundary;

    BaseUseCase() {
        options = new HashMap<>();
        authManager = new AuthManager();
        options.put("clientId", Connect.getInstance().getClientId());
        options.put("clientSecret", Connect.getInstance().getClientSecret());
    }

    void request() {
        authManager.authRequestToken(options, callbackBoundary);
    }
}
