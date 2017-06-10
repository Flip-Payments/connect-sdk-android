package com.flip.connect.presentation.login;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;

import com.flip.connect.Connect;
import com.flip.connect.presentation.base.BaseWebClient;

/**
 * Created by JGabrielFreitas on 09/04/17.
 */

class LoginClient extends BaseWebClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url.contains(Connect.getInstance().getSchema() + "://" + Connect.getInstance().getHost())) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            view.getContext().startActivity(intent);
            ((Activity) view.getContext()).finish();
            return true;
        }
        return super.shouldOverrideUrlLoading(view, url);
    }
}
