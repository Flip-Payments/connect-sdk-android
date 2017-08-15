package com.flip.connect;

import com.flip.connect.data.model.tempProfile.TempProfile;
import com.flip.connect.domain.entities.Environment;

/**
 * Created by Kanda on 11/07/2017.
 */

public class ConnectConfigurations {
    private String clientId, host, schema, clientSecret, publicToken, fingerPrintID;
    private Environment environment;
    private TempProfile pendingProfile = null;



    String getClientId() {
        if (clientId == null)
            throw new RuntimeException("clientId not defined");
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    String getHost() {
        if (host == null)
            throw new RuntimeException("Host not defined");
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    String getSchema() {
        if (schema == null)
            throw new RuntimeException("Schema not defined");
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    String getClientSecret() {
        if (clientSecret == null)
            throw new RuntimeException("ClientSecret not defined");
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    String getPublicToken() {
        if (publicToken == null)
            throw new RuntimeException("PublicToken not defined");
        return publicToken;
    }

    public void setPublicToken(String publicToken) {
        throw new UnsupportedOperationException("PublicToken unsupported!");
//        this.publicToken = publicToken;
    }

    String getFingerPrintID() {
        if (fingerPrintID == null)
            throw new RuntimeException("FingerPrint not defined");
        return fingerPrintID;
    }

    public void setFingerPrintID(String fingerPrintID) {
        this.fingerPrintID = fingerPrintID;
    }

    public Environment getEnvironment() {
        if(environment == null)
            throw new RuntimeException("Environment not defined");
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public TempProfile getTempProfile() {
        return pendingProfile;
    }

    public void setTempProfile(TempProfile pendingProfile) {
        this.pendingProfile = pendingProfile;
    }


    public String getLoginUrl(){
        switch (this.getEnvironment()){
            case SANDBOX:
                return BuildConfig.FLIP_LOGIN_SANDBOX;
            case PRODUCTION:
                return BuildConfig.FLIP_LOGIN_PRODUCTION;
            default:
                throw new RuntimeException("Environment not configured to get base url");
        }
    }

    public String getBaseApiUrl(){
        switch (this.getEnvironment()){
            case SANDBOX:
                return BuildConfig.API_BASE_URL_SANDBOX;
            case PRODUCTION:
                return BuildConfig.API_BASE_URL_SANDBOX;
            default:
                throw new RuntimeException("Environment not configured to get base url");
        }
    }

    public String getPrivateApiUrl(){
        switch (this.getEnvironment()){
            case SANDBOX:
                return BuildConfig.PRIVATE_API_SANDBOX;
            case PRODUCTION:
                return BuildConfig.PRIVATE_API_PRODUCTION;
            default:
                throw new RuntimeException("Environment not configured to get private url");
        }
    }

}
