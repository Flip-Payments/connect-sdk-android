package com.flip.connect.domain.repository;

import com.flip.connect.domain.boundary.CallbackBoundary;

/**
 * Created by Kanda on 10/07/2017.
 */

public interface UserRepository {

    void getUser(String accountKey, CallbackBoundary callbackBoundary);
}
