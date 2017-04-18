package com.flip.connect.util.client;

import android.app.Activity;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.flip.connect.interfaces.CheckoutCallback;
import com.jgabrielfreitas.datacontroller.DataController;

/**
 * Created by JGabrielFreitas on 18/04/17.
 */

public class CheckoutClient extends BaseWebClient {

  private CheckoutCallback checkoutCallback;

  public CheckoutClient(CheckoutCallback checkoutCallback) {
    this.checkoutCallback = checkoutCallback;
  }

  @Override public void onPageFinished(WebView view, String url) {
    super.onPageFinished(view, url);
    if (getCookie(url, "paymentResponse") != null && checkoutCallback != null) {
      this.checkoutCallback.success(getCookie(url, "paymentResponse"));
      ((Activity) view.getContext()).finish();
      clearCookies(view.getContext());
    }
  }

  @Override public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
    return false;
  }
}
