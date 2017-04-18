package com.flip.connect.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import com.flip.connect.R;
import com.flip.connect.interfaces.AccountCallback;
import com.flip.connect.view.activities.LoginActivity;
import com.jgabrielfreitas.datacontroller.DataController;

/**
 * Created by JGabrielFreitas on 04/04/17.
 */

public class FlipAuthenticationButton extends FlipButton {

  public FlipAuthenticationButton(Context context) {
    super(context);
  }

  public FlipAuthenticationButton(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public FlipAuthenticationButton(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override protected int getTextButton() {
    return R.string.login;
  }

  public void setAccountCallback(AccountCallback accountCallback) {
    LoginActivity.accountCallback = accountCallback;
  }

  @Override public void onClick(View view) {

    String token = new DataController(getContext()).readStringData("account");

    if (token == null) {
      getContext().startActivity(new Intent(getContext(), LoginActivity.class));
    } else {

      // check if the callback is not null to pass token
      if (LoginActivity.accountCallback != null)
        LoginActivity.accountCallback.success(token);
    }
  }

  @Override protected boolean isValid() {
    return false;
  }
}
