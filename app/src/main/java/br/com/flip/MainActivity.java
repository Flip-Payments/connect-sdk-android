package br.com.flip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;
import butterknife.Bind;
import com.flip.connect.*;
import com.flip.connect.interfaces.AccountCallback;
import com.flip.connect.widget.ConnectButton;
import com.jgabrielfreitas.core.activity.BaseActivity;
import com.jgabrielfreitas.layoutid.annotations.InjectLayout;

import static br.com.flip.BuildConfig.MERCHANT_KEY;

@InjectLayout(layout = R.layout.activity_main)
public class MainActivity extends BaseActivity implements AccountCallback {

  @Bind(R.id.connectButton) ConnectButton connectButton;
  AccountCallback accountCallback = this;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Flip.initalize(MERCHANT_KEY);
  }

  @Override protected void onStart() {
    super.onStart();
    connectButton.setAccountCallback(accountCallback);
  }

  @Override public void success(String response) {
    Toast.makeText(this, "login realizado com sucesso!", Toast.LENGTH_SHORT).show();
    Log.d("account token", response);
  }

  @Override public void error(Exception e, String message) {

  }
}
