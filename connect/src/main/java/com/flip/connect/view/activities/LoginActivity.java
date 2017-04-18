package com.flip.connect.view.activities;

import android.webkit.WebViewClient;
import com.flip.connect.Flip;
import com.flip.connect.interfaces.AccountCallback;
import com.flip.connect.util.LoginClient;

import static com.flip.connect.BuildConfig.FLIP_LOGIN;
import static com.flip.connect.BuildConfig.KEY;

public class LoginActivity extends BaseFlipActivity {

  public static AccountCallback accountCallback;

  @Override protected String urlToLoad() {
    return FLIP_LOGIN.replace(KEY, Flip.getClientId());
  }

  @Override protected WebViewClient client() {
    return new LoginClient(accountCallback);
  }
}
