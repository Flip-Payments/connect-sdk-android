package com.flip.connect.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.flip.connect.R;

import static android.R.color.white;

/**
 * Created by JGabrielFreitas on 17/04/17.
 */

abstract class FlipButton extends AppCompatButton implements View.OnClickListener {

  public FlipButton(Context context) {
    this(context, null);
  }

  public FlipButton(Context context, AttributeSet attrs) {
    this(context, attrs, android.support.v7.appcompat.R.attr.buttonStyle);
  }

  public FlipButton(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    setOnClickListener(this);
    setBackground(ContextCompat.getDrawable(getContext(), R.drawable.flip_style_selector));
    setTextColor(getResources().getColor(white));
    setText(getTextButton());
    Drawable icon = getContext().getResources().getDrawable(R.drawable.ic_logo);
    setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null);
  }

  protected abstract int getTextButton();

  @Override public void onClick(View view) {}

  protected abstract boolean isValid();

  protected void logError(String error) {
    Log.e("error", error);
  }

}
