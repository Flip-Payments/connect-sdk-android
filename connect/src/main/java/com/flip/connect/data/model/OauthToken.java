package com.flip.connect.data.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private List<Object> operationReport = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenCreateDate() {
        return tokenCreateDate;
    }

    public void setTokenCreateDate(String tokenCreateDate) {
        this.tokenCreateDate = tokenCreateDate;
    }

    public String getTokenExpiryDate() {
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

    public String getAccountKey() {
        return accountKey;
    }

    public void setAccountKey(String accountKey) {
        this.accountKey = accountKey;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Object> getOperationReport() {
        return operationReport;
    }

    public void setOperationReport(List<Object> operationReport) {
        this.operationReport = operationReport;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
