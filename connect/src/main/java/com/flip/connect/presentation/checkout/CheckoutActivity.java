package com.flip.connect.presentation.checkout;

import android.webkit.WebViewClient;
import com.flip.connect.domain.boundary.CheckoutCallback;
import com.flip.connect.presentation.base.BaseFlipActivity;
import com.flip.connect.presentation.checkout.CheckoutClient;

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
