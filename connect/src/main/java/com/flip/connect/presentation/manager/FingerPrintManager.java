package com.flip.connect.presentation.manager;

import android.content.Context;

import com.flip.connect.Connect;
import com.flip.connect.domain.model.auth.OauthToken;

import br.com.rexlab.fplib.FingerPrintLibrary;

/**
 * Created by ltorres on 24/07/2017.
 */

public class FingerPrintManager {
    public static void sendFingerPrint(Context context, OauthToken token) {
        //region Fingerprint
        FingerPrintLibrary.initFingerprint(
                context,
                Connect.getInstance().getEnvironment().name(),
                Connect.getInstance().getFingerPrintID(),
                token.getUserKey(),
                Connect.getInstance().getFingerPrintSessionId());

        FingerPrintLibrary.configFingerprint(true, true, true, true, true, true);
        FingerPrintLibrary.getFingerprint();
        //endregion
    }
}
