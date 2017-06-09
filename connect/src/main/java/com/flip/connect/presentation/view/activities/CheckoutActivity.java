package com.flip.connect.presentation.view.activities;

import android.webkit.WebViewClient;
import com.flip.connect.domain.boundary.CheckoutCallback;
import com.flip.connect.presentation.client.CheckoutClient;

public final class CheckoutActivity extends BaseFlipActivity {

  public static CheckoutCallback checkoutCallback;
  public static String checkoutUrl;

  @Override protected String urlToLoad() {
    return checkoutUrl;
  }

  @Override protected WebViewClient client() {
    return new CheckoutClient(checkoutCallback);
  }
}
