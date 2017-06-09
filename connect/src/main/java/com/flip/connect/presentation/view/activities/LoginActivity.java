package com.flip.connect.presentation.view.activities;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebViewClient;

import com.flip.connect.Flip;
import com.flip.connect.domain.boundary.AccountCallback;

import com.flip.connect.presentation.client.LoginClient;
import com.jgabrielfreitas.datacontroller.DataController;

import static com.flip.connect.BuildConfig.FLIP_LOGIN;
import static com.flip.connect.BuildConfig.KEY;

public final class LoginActivity extends BaseFlipActivity {

    public static AccountCallback accountCallback;

    @Override
    protected String urlToLoad() {
        return FLIP_LOGIN.replace(KEY, Flip.getClientId());
    }

    @Override
    protected WebViewClient client() {
        return new LoginClient(accountCallback);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Uri uri = getIntent().getData();
        if (uri != null) {
            String authCode = uri.getQueryParameter("code");
            new DataController(this).writeData("code", authCode);

        } else {
            loadWebView();
        }
    }
}
