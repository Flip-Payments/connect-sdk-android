package com.flip.connect.domain.usecase;

import com.flip.connect.Connect;
import com.flip.connect.data.repository.api.auth.AuthManager;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.repository.AuthRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jcosilva on 10/07/2017.
 */

public abstract class BaseUseCase {
    protected AuthRepository authManager;
    protected Map<String, String> options;
    protected CallbackBoundary callbackBoundary;

    protected BaseUseCase() {
        options = new HashMap<>();
        authManager = new AuthManager();
        options.put(Options.CLIENT_ID.toString(), Connect.getInstance().getClientId());
        options.put(Options.CLIENT_SECRET.toString(), Connect.getInstance().getClientSecret());
    }

    protected void request() {
        authManager.authRequestToken(options, callbackBoundary);
    }
}
