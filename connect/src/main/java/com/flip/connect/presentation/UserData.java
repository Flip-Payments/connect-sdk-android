package com.flip.connect.presentation;

import android.content.Context;

import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.user.UserResponse;
import com.flip.connect.domain.usecase.publicProfile.ProfileUseCase;

/**
 * Created by Kanda on 11/07/2017.
 */

public class UserData {

    private ProfileUseCase profileUseCase;
    private Context context;

    public UserData(Context context) {
        this.context = context;
        profileUseCase = new ProfileUseCase(context);
    }

    public void getUserInformation(CallbackBoundary<UserResponse> boundary) {
        //        profileUseCase.getProfile(boundary);
        throw new UnsupportedOperationException("Unsupported operation to get user information.");
    }
}
