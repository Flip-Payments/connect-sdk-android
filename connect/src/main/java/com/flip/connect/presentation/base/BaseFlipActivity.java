package com.flip.connect.presentation.base;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.flip.connect.R;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.LOLLIPOP;

/**
 * Created by JGabrielFreitas on 17/04/17.
 */

public abstract class BaseFlipActivity extends Activity {

    WebView flipWebView;
    ProgressBar connectProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        connectProgressBar = (ProgressBar) findViewById(R.id.progress);
    }

    protected abstract String urlToLoad();

    protected abstract WebViewClient client();

    public void loadWebView() {
        flipWebView = (WebView) findViewById(R.id.flipWebView);
        flipWebView.setWebViewClient(client());
        flipWebView.loadUrl(urlToLoad());
        Log.e("URL", urlToLoad());
        flipWebView.getSettings().setJavaScriptEnabled(true);
        flipWebView.getSettings().setAppCacheEnabled(true);
        CookieManager.getInstance().setAcceptCookie(true);
        if (SDK_INT >= LOLLIPOP)
            CookieManager.getInstance().setAcceptThirdPartyCookies(flipWebView, true);
    }

    public void showProgress() {
        connectProgressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgress() {
        connectProgressBar.setVisibility(View.GONE);
    }
}
