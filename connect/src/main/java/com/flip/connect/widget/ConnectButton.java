package com.flip.connect.widget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;
import com.flip.connect.interfaces.AccountCallback;
import com.flip.connect.view.activities.LoginActivity;
import com.jgabrielfreitas.datacontroller.DataController;

/**
 * Created by JGabrielFreitas on 04/04/17.
 */

public class ConnectButton extends AppCompatButton implements View.OnClickListener {

  public ConnectButton(Context context) {
    super(context);
    init();
  }

  public ConnectButton(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }


  public ConnectButton(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    setOnClickListener(this);
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
}
