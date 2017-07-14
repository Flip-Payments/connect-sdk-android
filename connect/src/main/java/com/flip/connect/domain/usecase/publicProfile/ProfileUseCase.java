package com.flip.connect.domain.usecase.publicProfile;

import android.content.Context;

import com.flip.connect.data.dependencies.TokenType;
import com.flip.connect.data.repository.api.user.UserManager;
import com.flip.connect.data.repository.local.LocalDataManager;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.user.UserResponse;
import com.flip.connect.domain.repository.LocalRepository;
import com.flip.connect.domain.repository.PublicDataRepository;
import com.flip.connect.domain.usecase.BaseUseCase;

/**
 * Created by Kanda on 11/07/2017.
 */

public class ProfileUseCase extends BaseUseCase {

    private PublicDataRepository userRepository;
    private LocalRepository localRepository;

    public ProfileUseCase(Context context) {
        super();
        userRepository = new UserManager();
        localRepository = new LocalDataManager(context);
    }

    public void getProfile(CallbackBoundary<UserResponse> callbackBoundary) {
        userRepository.getUser(localRepository.getOauth(TokenType.ACCESS_TOKEN),callbackBoundary);
    }

}
