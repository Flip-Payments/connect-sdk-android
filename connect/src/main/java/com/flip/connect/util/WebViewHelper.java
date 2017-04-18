package com.flip.connect.util;

import android.webkit.CookieManager;
import android.webkit.WebView;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.LOLLIPOP;

/**
 * Created by JGabrielFreitas on 17/04/17.
 */

public class WebViewHelper {

  public static void prepareWebView(WebView webView) {
    webView.getSettings().setJavaScriptEnabled(true);
    webView.getSettings().setAppCacheEnabled(true);
    CookieManager.getInstance().setAcceptCookie(true);
    if (SDK_INT >= LOLLIPOP)
      CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
  }

}
