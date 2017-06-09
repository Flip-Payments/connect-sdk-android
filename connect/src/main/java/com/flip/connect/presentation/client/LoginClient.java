package com.flip.connect.presentation.client;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;

import com.flip.connect.domain.boundary.AccountCallback;
import com.jgabrielfreitas.datacontroller.DataController;

/**
 * Created by JGabrielFreitas on 09/04/17.
 */

public class LoginClient extends BaseWebClient {

    private AccountCallback accountCallback;

    public LoginClient(AccountCallback accountCallback) {
        this.accountCallback = accountCallback;
    }

    @Override
    public void onPageFinished(WebView view, String url) {

        if (getCookie(url, "account") != null && accountCallback != null) {
            this.accountCallback.success(getCookie(url, "account"));
            new DataController(view.getContext()).writeData("account", getCookie(url, "account"));
            ((Activity) view.getContext()).finish();
        }
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url.contains("ipirangaconnect://")) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            view.getContext().startActivity(intent);
            return true;
        }
        return super.shouldOverrideUrlLoading(view, url);
    }
}
