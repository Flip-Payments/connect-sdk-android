package com.flip.connect.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import com.flip.connect.R;
import com.flip.connect.interfaces.CheckoutCallback;
import com.flip.connect.interfaces.CheckoutGrabber;
import com.flip.connect.model.checkout.Transaction;
import com.flip.connect.view.activities.CheckoutActivity;

import static com.flip.connect.BuildConfig.FLIP_CHECKOUT;
import static com.flip.connect.BuildConfig.KEY;
import static java.lang.String.format;

/**
 * Created by JGabrielFreitas on 17/04/17.
 */

public class FlipCheckoutButton extends FlipButton {

  private CheckoutGrabber grabber;
  private CheckoutCallback checkoutCallback;

  public FlipCheckoutButton(Context context) {
    super(context);
  }

  public FlipCheckoutButton(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public FlipCheckoutButton(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  public void setGrabber(CheckoutGrabber grabber) {
    this.grabber = grabber;
  }

  public void setCheckoutCallback(CheckoutCallback checkoutCallback) {
    this.checkoutCallback = checkoutCallback;
  }

  @Override protected int getTextButton() {
    return R.string.pay_with_flipconnect;
  }

  @Override public void onClick(View view) {
    super.onClick(view);

    if (isValid()) {
      //logError(buildCheckoutUrl(grabber.getTransaction()));
      CheckoutActivity.checkoutUrl = buildCheckoutUrl(grabber.getTransaction());
      getContext().startActivity(new Intent(getContext(), CheckoutActivity.class));

    } else
      logError("grabber or checkoutCallback is null");
  }

  @Override protected boolean isValid() {
    return grabber != null && checkoutCallback != null && grabber.getTransaction() != null;
  }

  private String buildCheckoutUrl(Transaction transaction) {

    StringBuilder checkoutUrl = new StringBuilder(FLIP_CHECKOUT.replace(KEY, transaction.getClientId()));
    checkoutUrl.append(format("&totalAmount=%d", transaction.getTotalAmount()));
    checkoutUrl.append(format("&installments=%d", transaction.getInstallments()));
    checkoutUrl.append(format("&statementDescriptor=%s", transaction.getStatementDescriptor()));
    checkoutUrl.append(format("&successUrl=%s", transaction.getSuccessUrl()));

    return checkoutUrl.toString();
  }

}
