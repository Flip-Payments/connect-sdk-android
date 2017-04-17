package com.flip.connect.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.flip.connect.R;

/**
 * Created by JGabrielFreitas on 17/04/17.
 */

public class FlipCheckoutButton extends FlipButton {

  public FlipCheckoutButton(Context context) {
    super(context);
  }

  public FlipCheckoutButton(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public FlipCheckoutButton(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override protected int getTextButton() {
    return R.string.pay_with_flipconnect;
  }
}
