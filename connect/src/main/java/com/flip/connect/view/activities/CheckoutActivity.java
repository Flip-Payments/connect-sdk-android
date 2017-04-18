package com.flip.connect.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebViewClient;
import com.flip.connect.R;
import com.flip.connect.interfaces.AccountCallback;
import com.flip.connect.interfaces.CheckoutCallback;
import com.flip.connect.model.checkout.Transaction;

public class CheckoutActivity extends BaseFlipActivity {

  public static CheckoutCallback checkoutCallback;
  public static String checkoutUrl;

  @Override protected String urlToLoad() {
    return checkoutUrl;
  }

  @Override protected WebViewClient client() {
    return null;
  }
}
