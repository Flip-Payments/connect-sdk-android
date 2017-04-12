package com.flip.connect.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.flip.connect.BuildConfig;
import com.flip.connect.Flip;
import com.flip.connect.R;
import com.flip.connect.util.LoginClient;

import static com.flip.connect.BuildConfig.FLIP_LOGIN;
import static com.flip.connect.BuildConfig.KEY;

public class LoginActivity extends AppCompatActivity {

    WebView flipWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        flipWebView = (WebView) findViewById(R.id.flipWebView);
        flipWebView.setWebViewClient(new LoginClient());
        flipWebView.getSettings().setJavaScriptEnabled(true);
        flipWebView.getSettings().setAppCacheEnabled(true);
        flipWebView.loadUrl(FLIP_LOGIN.replace(KEY, Flip.getMerchantKey()));
    }
}
