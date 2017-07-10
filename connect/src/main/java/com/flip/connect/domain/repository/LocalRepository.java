package com.flip.connect.domain.repository;

import com.flip.connect.data.dependencies.TokenType;
import com.flip.connect.domain.model.OauthToken;

/**
 * Created by jcosilva on 6/9/2017.
 */

public interface LocalRepository {
    void saveOauth(OauthToken token, TokenType tokenType);

    OauthToken getOauth(TokenType tokenType);
}
