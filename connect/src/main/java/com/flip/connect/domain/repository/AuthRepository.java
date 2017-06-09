package com.flip.connect.domain.repository;

import java.util.Map;

/**
 * Created by jcosilva on 6/8/2017.
 */

public interface AuthRepository {

    void authRefreshToken(Map<String, String> options);
}
