package com.flip.connect.util;

import android.app.Activity;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.flip.connect.interfaces.AccountCallback;
import com.jgabrielfreitas.datacontroller.DataController;

/**
 * Created by JGabrielFreitas on 09/04/17.
 */

public class LoginClient extends WebViewClient {

  private AccountCallback accountCallback;

  public LoginClient(AccountCallback accountCallback) {
    this.accountCallback = accountCallback;
  }

  @Override public void onPageFinished(WebView view, String url) {

    if (getCookie(url, "account") != null && accountCallback != null) {
      this.accountCallback.success(getCookie(url, "account"));
      new DataController(view.getContext()).writeData("account", getCookie(url, "account"));
      ((Activity) view.getContext()).finish();
    }
  }

  public String getCookie(String siteName, String cookieName) {
    String cookieValue = null;

    CookieManager cookieManager = CookieManager.getInstance();
    String cookies = cookieManager.getCookie(siteName);
    if (cookies !=null) {
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
}
