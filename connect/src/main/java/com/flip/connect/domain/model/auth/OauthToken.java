package com.flip.connect.domain.model.auth;

import com.flip.connect.domain.model.BaseResponse;

import java.util.List;

/**
 * Created by jcosilva on 6/8/2017.
 */

public class OauthToken extends BaseResponse {
    private String accessToken;
    private String tokenCreateDate;
    private String tokenExpiryDate;
    private String refreshToken;
    private String userKey;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Object getTokenCreateDate() {
        return tokenCreateDate;
    }

    public void setTokenCreateDate(String tokenCreateDate) {
        this.tokenCreateDate = tokenCreateDate;
    }

    public Object getTokenExpiryDate() {
        return tokenExpiryDate;
    }

    public void setTokenExpiryDate(String tokenExpiryDate) {
        this.tokenExpiryDate = tokenExpiryDate;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    @Override
    public String toString() {
        return "OauthToken{" +
                "accessToken=" + accessToken +
                ", tokenCreateDate=" + tokenCreateDate +
                ", tokenExpiryDate=" + tokenExpiryDate +
                ", refreshToken=" + refreshToken +
                ", userKey=" + userKey +
                ", success=" + getSuccess() +
                ", operationReport=" + getOperationReport() +
                '}';
    }
}
