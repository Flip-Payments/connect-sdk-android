package com.flip.connect;

import android.content.Context;

import com.flip.connect.data.repository.local.LocalDataManager;
import com.flip.connect.domain.entities.Environment;
import com.flip.connect.domain.entities.TokenType;
import com.flip.connect.domain.model.auth.OauthToken;
import com.flip.connect.domain.repository.LocalRepository;
import com.flip.connect.presentation.manager.FingerPrintManager;
import com.flip.connect.presentation.util.StringUtil;

import java.util.UUID;

/**
 * Created by JGabrielFreitas on 04/04/17.
 */

public class Connect {
    private static final Connect instance = new Connect();

    private Context context;
    private LocalRepository localManager;
    private ConnectConfigurations connectConfigurations;

    private String fingerPrintSessionId, dataKey;



    public static Connect getInstance() {
        return instance;
    }

    public static void initializer(Context context, ConnectConfigurations configurations) {
        getInstance().context = context;
        getInstance().connectConfigurations = configurations;

        getInstance().localManager = new LocalDataManager(context);

        if(getInstance().getToken() != null){

            FingerPrintManager.sendFingerPrint(
                    context,
                    getInstance().getToken()
            );

        }
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

    public String getFingerPrintSessionId() {
        if (StringUtil.isEmptyOrNull(fingerPrintSessionId)) {
            fingerPrintSessionId = UUID.randomUUID().toString();
        }
        return fingerPrintSessionId;
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

    public OauthToken getToken() {
        return localManager.getOauth(TokenType.ACCESS_TOKEN);
    }

    public Environment getEnvironment(){
        return connectConfigurations.getEnvironment();
    }

    public String getLoginUrl(){
        return connectConfigurations.getLoginUrl();
    }

    public String getBaseApiUrl(){
       return connectConfigurations.getBaseApiUrl();
    }

    public String getPrivateApiUrl(){
        return connectConfigurations.getPrivateApiUrl();
    }

}
