package com.flip.connect.util.client;

import android.content.Context;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebViewClient;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.LOLLIPOP_MR1;
import static android.webkit.CookieManager.getInstance;
import static android.webkit.CookieSyncManager.createInstance;
import static java.lang.String.valueOf;

/**
 * Created by JGabrielFreitas on 18/04/17.
 */

abstract class BaseWebClient extends WebViewClient {

  protected String getCookie(String siteName, String cookieName) {
    String cookieValue = null;

    CookieManager cookieManager = getInstance();
    String cookies = cookieManager.getCookie(siteName);
    if (cookies != null) {
      String[] temp = cookies.split(";");
      for (String ar1 : temp) {
        if (ar1.contains(cookieName)) {
          String[] temp1 = ar1.split("=");
          cookieValue = temp1[1];
          break;
        }
      }
    }
    return cookieValue;
  }

  protected void clearCookies(Context context) {

    if (SDK_INT >= LOLLIPOP_MR1) {
      Log.d("webclient", "Using clearCookies code for API >=" + valueOf(LOLLIPOP_MR1));
      getInstance().removeAllCookies(null);
      getInstance().flush();
    } else {
      Log.d("webclient", "Using clearCookies code for API <" + valueOf(LOLLIPOP_MR1));
      CookieSyncManager cookieSyncMngr = createInstance(context);
      cookieSyncMngr.startSync();
      CookieManager cookieManager = getInstance();
      cookieManager.removeAllCookie();
      cookieManager.removeSessionCookie();
      cookieSyncMngr.stopSync();
      cookieSyncMngr.sync();
    }
  }
}
