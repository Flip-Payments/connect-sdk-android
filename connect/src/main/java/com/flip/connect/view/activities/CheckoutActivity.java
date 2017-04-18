package com.flip.connect.view.activities;

import android.webkit.WebViewClient;
import com.flip.connect.interfaces.CheckoutCallback;
import com.flip.connect.util.CheckoutClient;

public class CheckoutActivity extends BaseFlipActivity {

  public static CheckoutCallback checkoutCallback;
  public static String checkoutUrl;

  @Override protected String urlToLoad() {
    return checkoutUrl;
  }

  @Override protected WebViewClient client() {
    return new CheckoutClient(checkoutCallback);
  }
}
