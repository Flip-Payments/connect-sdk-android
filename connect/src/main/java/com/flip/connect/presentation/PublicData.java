package com.flip.connect.presentation;

import android.content.Context;

import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.user.UserResponse;
import com.flip.connect.domain.usecase.profile.ProfileUseCase;

/**
 * Created by Kanda on 11/07/2017.
 */

public class PublicData {

    private ProfileUseCase profileUseCase;

    public PublicData(Context context) {
        profileUseCase = new ProfileUseCase(context);
    }

    public void getUserInformation(CallbackBoundary<UserResponse> boundary) {
        profileUseCase.getProfile(boundary);
    }
}
