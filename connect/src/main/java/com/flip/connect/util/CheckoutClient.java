package com.flip.connect.util;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.flip.connect.interfaces.CheckoutCallback;

/**
 * Created by JGabrielFreitas on 18/04/17.
 */

public class CheckoutClient extends WebViewClient {

  private CheckoutCallback checkoutCallback;

  public CheckoutClient(CheckoutCallback checkoutCallback) {
    this.checkoutCallback = checkoutCallback;
  }

  @Override public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
    return false;
  }
}
