package com.flip.connect;

import android.content.Context;

/**
 * Created by JGabrielFreitas on 04/04/17.
 */

public class Connect {

    private String clientId;
    private String host;
    private String schema;
    private String clientSecret;
    private static final Connect instance = new Connect();
    private String uniqueId;

    public static Connect getInstance() {
        return instance;
    }

    public static void initializer(String clientId, String host, String schema, String clientSecret) {
        getInstance().clientId = clientId;
        getInstance().host = host;
        getInstance().schema = schema;
        getInstance().clientSecret = clientSecret;
    }

    public String getClientId() {
        if (clientId == null)
            throw new RuntimeException("clientId not defined");
        return getInstance().clientId;
    }

    public String getHost() {
        if (host == null)
            throw new RuntimeException("Host not defined");
        return host;
    }

    public String getSchema() {
        if (schema == null)
            throw new RuntimeException("Schema not defined");
        return schema;
    }

    public String getClientSecret() {
        if (schema == null)
            throw new RuntimeException("ClientSecret not defined");
        return clientSecret;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}
