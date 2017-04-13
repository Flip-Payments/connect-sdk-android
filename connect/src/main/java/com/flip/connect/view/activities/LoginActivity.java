package com.flip.connect.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.flip.connect.Flip;
import com.flip.connect.R;
import com.flip.connect.interfaces.AccountCallback;
import com.flip.connect.util.LoginClient;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.LOLLIPOP;
import static com.flip.connect.BuildConfig.FLIP_LOGIN;
import static com.flip.connect.BuildConfig.KEY;

public class LoginActivity extends AppCompatActivity {

  WebView flipWebView;
  public static AccountCallback accountCallback;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    flipWebView = (WebView) findViewById(R.id.flipWebView);
    flipWebView.setWebViewClient(new LoginClient(accountCallback));
    flipWebView.getSettings().setJavaScriptEnabled(true);
    flipWebView.getSettings().setAppCacheEnabled(true);
    CookieManager.getInstance().setAcceptCookie(true);
    if (SDK_INT >= LOLLIPOP) {
      CookieManager.getInstance().setAcceptThirdPartyCookies(flipWebView, true);
    }
  flipWebView.loadUrl(FLIP_LOGIN.replace(KEY, Flip.getMerchantKey()));
  }
}
