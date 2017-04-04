package com.flip.connect.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.support.v7.widget.AppCompatButton;
import android.widget.Toast;

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

  @Override public void onClick(View view) {
    Toast.makeText(getContext(), "flip connect!", Toast.LENGTH_SHORT).show();
  }
}
