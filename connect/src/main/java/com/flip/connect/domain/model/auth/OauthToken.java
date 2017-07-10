package com.flip.connect.domain.model.auth;

import java.util.List;

/**
 * Created by jcosilva on 6/8/2017.
 */

public class OauthToken {
    private String accessToken;
    private String tokenCreateDate;
    private String tokenExpiryDate;
    private String refreshToken;
    private String accountKey;
    private Boolean success;
    private List<OperationReport> operationReport = null;

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

    public Object getAccountKey() {
        return accountKey;
    }

    public void setAccountKey(String accountKey) {
        this.accountKey = accountKey;
    }

    public Boolean hasSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<OperationReport> getOperationReport() {
        return operationReport;
    }

    public void setOperationReport(List<OperationReport> operationReport) {
        this.operationReport = operationReport;
    }

    @Override
    public String toString() {
        return "OauthToken{" +
                "accessToken=" + accessToken +
                ", tokenCreateDate=" + tokenCreateDate +
                ", tokenExpiryDate=" + tokenExpiryDate +
                ", refreshToken=" + refreshToken +
                ", accountKey=" + accountKey +
                ", success=" + success +
                ", operationReport=" + operationReport +
                '}';
    }
}
