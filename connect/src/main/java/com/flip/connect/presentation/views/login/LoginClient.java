package com.flip.connect.presentation.views.login;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;

import com.flip.connect.Connect;
import com.flip.connect.domain.boundary.AccountCallback;
import com.flip.connect.presentation.base.BaseWebClient;
import com.flip.connect.presentation.exceptions.InvalidRedirectThrowable;
import com.flip.connect.presentation.exceptions.InvalidStateThrowable;

/**
 * Created by JGabrielFreitas on 09/04/17.
 */

class LoginClient extends BaseWebClient {
    private String uuid;
    private AccountCallback accountCallback;

    public LoginClient(String uuid, AccountCallback accountCallback) {
        this.uuid = uuid;
        this.accountCallback = accountCallback;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        String redirect = Connect.getInstance().getSchema() + "://" + Connect.getInstance().getHost();
        if (!url.contains(uuid)) {
            accountCallback.error(new InvalidStateThrowable());
            ((Activity) view.getContext()).finish();
            return false;
        }
        if (!url.contains(redirect)) {
            accountCallback.error(new InvalidRedirectThrowable());
            ((Activity) view.getContext()).finish();
            return false;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        view.getContext().startActivity(intent);
        ((Activity) view.getContext()).finish();
        return true;
    }
}
