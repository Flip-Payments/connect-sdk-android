package com.flip.connect;

import com.flip.connect.presentation.util.StringUtil;

import java.util.UUID;

/**
 * Created by JGabrielFreitas on 04/04/17.
 */

public class Connect {
    private static final Connect instance = new Connect();
    private ConnectConfigurations connectConfigurations;
    private String uniqueId, dataKey;

    public static Connect getInstance() {
        return instance;
    }

    public static void initializer(ConnectConfigurations configurations) {
        getInstance().connectConfigurations = configurations;
    }

    public String getClientId() {
        return connectConfigurations.getClientId();
    }

    public String getHost() {
        return connectConfigurations.getHost();
    }

    public String getSchema() {
        return connectConfigurations.getSchema();
    }

    public String getClientSecret() {
        return connectConfigurations.getClientSecret();
    }

    public String getPublicToken() {
        return connectConfigurations.getPublicToken();
    }

    public String getUniqueId() {
        if (StringUtil.isEmptyOrNull(uniqueId))
            uniqueId = UUID.randomUUID().toString();

        return uniqueId;
    }

    public String getFingerPrintID(){
        return connectConfigurations.getFingerPrintID();
    }

    public String getDataKey() {
        return dataKey;
    }

    public void setDataKey(String dataKey) {
        this.dataKey = dataKey;
    }

    public ConnectConfigurations getConnectConfigurations() {
        return connectConfigurations;
    }
}
