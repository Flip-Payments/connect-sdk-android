package com.flip.connect.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.user.UserResponse;
import com.flip.connect.domain.usecase.publicProfile.ProfileUseCase;
import com.flip.connect.presentation.categories.Category;
import com.flip.connect.presentation.views.edit.EditionActivity;

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
        profileUseCase.getProfile(boundary);
    }

    public void editInformations(@NonNull Category... categories) {
        if (context != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("CATEGORY", categories);
            context.startActivity(new Intent(context, EditionActivity.class).putExtras(bundle));
        }
    }
}
