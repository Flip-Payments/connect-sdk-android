package com.flip.connect.presentation.views.login;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebViewClient;

import com.flip.connect.Connect;
import com.flip.connect.domain.boundary.AccountCallback;
import com.flip.connect.domain.model.auth.OauthToken;
import com.flip.connect.presentation.base.BaseFlipActivity;

import java.util.UUID;

import static com.flip.connect.BuildConfig.DATA_KEY;
import static com.flip.connect.BuildConfig.HOST;
import static com.flip.connect.BuildConfig.KEY;
import static com.flip.connect.BuildConfig.SCHEMA;
import static com.flip.connect.BuildConfig.STATE;

public final class LoginActivity extends BaseFlipActivity implements LoginContract.View {

    public static AccountCallback accountCallback;
    private LoginContract.Presenter presenter;
    private String uuid;

    @Override
    protected String urlToLoad() {

        if (Connect.getInstance().getConnectConfigurations().getTempProfile() != null)
            return Connect.getInstance().getLoginUrl()
                    .replace(KEY, Connect.getInstance().getClientId())
                    .replace(HOST, Connect.getInstance().getHost())
                    .replace(SCHEMA, Connect.getInstance().getSchema())
                    .replace(STATE, uuid)
                    .replace(DATA_KEY, Connect.getInstance().getDataKey() == null ? "" : Connect.getInstance().getDataKey());
        else {
            return Connect.getInstance().getLoginUrl()
                    .replace(KEY, Connect.getInstance().getClientId())
                    .replace(HOST, Connect.getInstance().getHost())
                    .replace(SCHEMA, Connect.getInstance().getSchema())
                    .replace(STATE, uuid);
        }
    }

    @Override
    protected WebViewClient client() {
        uuid = UUID.randomUUID().toString();
        return new LoginClient(uuid, accountCallback);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Uri uri = getIntent().getData();
        presenter = new LoginPresenter(this);
        presenter.attachView(this);
        if (uri != null) {
            showProgress();
            String authCode = uri.getQueryParameter("code");
            presenter.loadCredentials(authCode);
        } else {
            if (Connect.getInstance().getConnectConfigurations().getTempProfile() != null) {
                presenter.savePendingProfile(Connect.getInstance().getConnectConfigurations().getTempProfile());
            } else {
                loadWebView();
            }
        }
    }

    @Override
    public void goToWebView() {
        loadWebView();
    }

    @Override
    public void loginWithSuccess(OauthToken token) {
        accountCallback.success(token);
        finish();
    }

    @Override
    public void loginFailed(Throwable t) {
        accountCallback.error(t);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detach();
        }
    }
}
