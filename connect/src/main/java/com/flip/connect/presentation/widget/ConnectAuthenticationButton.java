package com.flip.connect.presentation.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;

import com.flip.connect.R;
import com.flip.connect.domain.boundary.AccountCallback;
import com.flip.connect.presentation.login.LoginActivity;

/**
 * Created by JGabrielFreitas on 04/04/17.
 */

public final class ConnectAuthenticationButton extends FlipButton {

    public ConnectAuthenticationButton(Context context) {
        super(context);
    }

    public ConnectAuthenticationButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ConnectAuthenticationButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int getTextButton() {
        return R.string.login;
    }

    public void setAccountCallback(AccountCallback accountCallback) {
        LoginActivity.accountCallback = accountCallback;
    }

    @Override
    public void onClick(View view) {
        getContext().startActivity(new Intent(getContext(), LoginActivity.class));
    }

    @Override
    protected boolean isValid() {
        return false;
    }
}
