package com.flip.connect.domain.repository;

import com.flip.connect.domain.entities.TokenType;
import com.flip.connect.domain.model.auth.OauthToken;

/**
 * Created by jcosilva on 6/9/2017.
 */

public interface LocalRepository {

    void saveOauth(OauthToken token, TokenType tokenType);

    void deleteOauth(TokenType tokenType);

    OauthToken getOauth(TokenType tokenType);
}
