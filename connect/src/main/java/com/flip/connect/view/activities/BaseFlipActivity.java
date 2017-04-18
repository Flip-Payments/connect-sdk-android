package com.flip.connect.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.flip.connect.R;
import com.flip.connect.util.WebViewHelper;

/**
 * Created by JGabrielFreitas on 17/04/17.
 */

abstract class BaseFlipActivity extends AppCompatActivity {

  WebView flipWebView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    flipWebView = (WebView) findViewById(R.id.flipWebView);
    WebViewHelper.prepareWebView(flipWebView);
    flipWebView.setWebViewClient(client());
    flipWebView.loadUrl(urlToLoad());
  }

  protected abstract String urlToLoad();

  protected abstract WebViewClient client();

}
