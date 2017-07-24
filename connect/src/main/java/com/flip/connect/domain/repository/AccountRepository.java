package com.flip.connect.domain.repository;

import com.flip.connect.data.model.PatchesBase;
import com.flip.connect.domain.model.account.AccountModel;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.BaseResponse;
import com.flip.connect.domain.model.auth.OauthToken;

/**
 * Created by Kanda on 13/07/2017.
 */

public interface AccountRepository {
    void getAccount(OauthToken token, CallbackBoundary<AccountModel> callbackBoundary);

    void updateAccount(OauthToken token, PatchesBase update, CallbackBoundary<BaseResponse> callbackBoundary);

    void getAddress();

    void getDocuments();

    void getPersonalData();
}
