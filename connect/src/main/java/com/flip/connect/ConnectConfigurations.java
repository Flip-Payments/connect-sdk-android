package com.flip.connect;

/**
 * Created by Kanda on 11/07/2017.
 */

public class ConnectConfigurations {
    private String clientId;
    private String host;
    private String schema;
    private String clientSecret;
    private String publicToken;
    private String fingerPrintID;

    String getClientId() {
        if (clientId == null)
            throw new RuntimeException("clientId not defined");
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    protected String getHost() {
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
        this.publicToken = publicToken;
    }

    String getFingerPrintID() {
        if (fingerPrintID == null)
            throw new RuntimeException("FingerPrint not defined");
        return fingerPrintID;
    }

    public void setFingerPrintID(String fingerPrintID) {
        this.fingerPrintID = fingerPrintID;
    }
}
