package br.com.flip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;
import butterknife.Bind;
import com.flip.connect.Flip;
import com.flip.connect.domain.boundary.AccountCallback;
import com.flip.connect.domain.boundary.CheckoutCallback;
import com.flip.connect.domain.boundary.CheckoutGrabber;
import com.flip.connect.data.model.checkout.Transaction;
import com.flip.connect.presentation.widget.FlipAuthenticationButton;
import com.flip.connect.presentation.widget.FlipCheckoutButton;
import com.jgabrielfreitas.core.activity.BaseActivity;
import com.jgabrielfreitas.layoutid.annotations.InjectLayout;

import static br.com.flip.BuildConfig.MERCHANT_KEY;

@InjectLayout(layout = R.layout.activity_main)
public class MainActivity extends BaseActivity implements CheckoutGrabber {

  @Bind(R.id.connectButton)  FlipAuthenticationButton connectButton;
  @Bind(R.id.checkoutButton) FlipCheckoutButton       checkoutButton;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Flip.initializer(MERCHANT_KEY,"ipiranga");
  }

  @Override protected void onStart() {
    super.onStart();

    connectButton.setAccountCallback(new AccountCallback() {
      @Override public void success(String response) {
        Toast.makeText(MainActivity.this, "login realizado com sucesso", Toast.LENGTH_SHORT).show();
      }

      @Override public void error(Exception e, String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
      }
    });

    checkoutButton.setGrabber(this);
    checkoutButton.setCheckoutCallback(new CheckoutCallback() {
      @Override public void success(String response) {
        Toast.makeText(MainActivity.this, "checkout realizado com sucesso!", Toast.LENGTH_SHORT)
            .show();
      }

      @Override public void error(Exception e, String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
      }
    });
  }

  @Override public Transaction getTransaction() {

    // create your transaction
    Transaction transaction = new Transaction();
    transaction.setTotalAmount(2000);
    transaction.setInstallments(3);
    transaction.setStatementDescriptor("description");
    transaction.setSuccessUrl("https://google.com/");

    return transaction;
  }
}
