package com.flip.connect.presentation.client;

import android.app.Activity;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.flip.connect.domain.boundary.CheckoutCallback;

/**
 * Created by JGabrielFreitas on 18/04/17.
 */

public class CheckoutClient extends BaseWebClient {

  private CheckoutCallback checkoutCallback;

  public CheckoutClient(CheckoutCallback checkoutCallback) {
    this.checkoutCallback = checkoutCallback;
  }

  @Override public void onPageFinished(WebView view, String url) {

    logCookies(url);

    // if has cookie, a transaction probably occurred
    if (checkIfHasPaymentCookie(url) && checkoutCallback != null) {

      // check cookie to see if is a valid cookie (!= 0)
      if (isAValidPaymentCookie(url)) {
        this.checkoutCallback.success(getCookie(url, "paymentResponse"));
        ((Activity) view.getContext()).finish();

        // reset paymentResponse cookie value
        resetPaymentCookie(url);
      }
    }
  }

  private void resetPaymentCookie(String url) {

    Log.e(TAG, "before reset paymentResponse");
    logCookies(url);

    CookieManager.getInstance().setCookie("paymentResponse", "0");


    Log.e(TAG, "after reset paymentResponse");
    logCookies(url);
  }

  private boolean isAValidPaymentCookie(String url) {
    return !getCookie(url, "paymentResponse").equals("0");
  }

  private boolean checkIfHasPaymentCookie(String url) {
    return getCookie(url, "paymentResponse") != null;
  }

  @Override public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
    return false;
  }
}
