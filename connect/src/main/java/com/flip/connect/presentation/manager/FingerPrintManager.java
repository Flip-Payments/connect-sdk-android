package com.flip.connect.presentation.manager;

import android.content.Context;
import android.util.Log;

import com.flip.connect.Connect;
import com.flip.connect.domain.model.auth.OauthToken;

import java.util.UUID;

/**
 * Created by ltorres on 24/07/2017.
 */

public class FingerPrintManager {
    /*public static void sendFingerPrint(Context context, OauthToken token) {
        //region Fingerprint
        String uniqueId = UUID.randomUUID().toString();
        Connect.getInstance().setUniqueId(uniqueId);
        FingerPrintLibrary.initFingerprint(context, "sandbox",
                "d82436c6-3664-467f-80eb-739017d13b1a", token.getUserKey(),
                uniqueId);
        Log.e("UNIQUE ID", Connect.getInstance().getUniqueId());
        FingerPrintLibrary.configFingerprint(true, true, true, true, true, true);
        FingerPrintLibrary.getFingerprint();
        //endregion
    }*/
}
