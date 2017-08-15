package com.flip.connect.domain.repository;

import com.flip.connect.data.model.tempProfile.TempProfile;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.BaseResponse;
import com.flip.connect.domain.model.account.AccountModel;
import com.flip.connect.domain.model.auth.OauthToken;
import com.flip.connect.domain.model.user.PendingProfile;
import com.google.gson.JsonObject;

/**
 * Created by Kanda on 13/07/2017.
 */

public interface AccountRepository {
    void getAccount(OauthToken token, CallbackBoundary<AccountModel> callbackBoundary);

    void savePendingProfile(String clientID, TempProfile body, CallbackBoundary<PendingProfile> callbackBoundary);
}
