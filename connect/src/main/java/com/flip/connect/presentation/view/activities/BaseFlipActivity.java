package com.flip.connect.presentation.view.activities;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.flip.connect.R;

/**
 * Created by JGabrielFreitas on 17/04/17.
 */

abstract class BaseFlipActivity extends Activity {

    WebView flipWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    protected abstract String urlToLoad();

    protected abstract WebViewClient client();

    public void loadWebView() {
        flipWebView = (WebView) findViewById(R.id.flipWebView);
        flipWebView.setWebViewClient(client());
        flipWebView.loadUrl(urlToLoad());
    }
}
