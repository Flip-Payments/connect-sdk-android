package com.flip.connect.util;

import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static android.content.ContentValues.TAG;

/**
 * Created by JGabrielFreitas on 09/04/17.
 */

public class LoginClient extends WebViewClient {

    @Override
    public void onPageFinished(WebView view, String url){
        String cookies = CookieManager.getInstance().getCookie(url);
        Log.d(TAG, "All the cookies in a string:" + cookies);
    }

}
