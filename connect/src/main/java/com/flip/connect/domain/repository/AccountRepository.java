package com.flip.connect.domain.repository;

import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.account.Account;

/**
 * Created by Kanda on 13/07/2017.
 */

public interface AccountRepository {
    void getAccount(CallbackBoundary<Account> callbackBoundary);

    void getAddress();

    void getDocuments();

    void getPersonalData();
}
