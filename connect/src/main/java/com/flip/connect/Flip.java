package com.flip.connect;

import android.content.Context;

import com.jgabrielfreitas.datacontroller.DataController;

/**
 * Created by JGabrielFreitas on 04/04/17.
 */

public class Flip {

    private String clientId;
    private String redirectUrl;
    private static final Flip instance = new Flip();

    public static Flip getInstance() {
        return instance;
    }

    private Flip() {
    }

    public static void initializer(String clientId, String redirectUrl) {
        getInstance().clientId = clientId;
        getInstance().redirectUrl = redirectUrl;
    }

    public static String getClientId() {
        return getInstance().clientId;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public static String getToken() {
        return UserInfo.getInstance().getToken();
    }

    public static void deleteAccountToken(Context context) {
        new DataController(context).remove("account");
    }


}
