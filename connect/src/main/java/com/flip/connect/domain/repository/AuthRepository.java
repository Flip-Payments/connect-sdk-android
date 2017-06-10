package com.flip.connect.domain.repository;

import com.flip.connect.domain.boundary.CallbackBoundary;

import java.util.Map;

/**
 * Created by jcosilva on 6/8/2017.
 */

public interface AuthRepository {

    void authRequestToken(Map<String, String> options, CallbackBoundary callbackBoundary);
}
