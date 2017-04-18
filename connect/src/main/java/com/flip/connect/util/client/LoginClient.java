package com.flip.connect.util.client;

import android.app.Activity;
import android.webkit.WebView;
import com.flip.connect.interfaces.AccountCallback;
import com.jgabrielfreitas.datacontroller.DataController;

/**
 * Created by JGabrielFreitas on 09/04/17.
 */

public class LoginClient extends BaseWebClient {

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
}
