package br.com.flip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.flip.connect.Connect;
import com.flip.connect.data.model.checkout.Transaction;
import com.flip.connect.domain.boundary.AccountCallback;
import com.flip.connect.domain.boundary.CheckoutGrabber;
import com.flip.connect.domain.model.OauthToken;
import com.flip.connect.presentation.auth.ConnectAuth;
import com.flip.connect.presentation.widget.ConnectAuthenticationButton;
import com.jgabrielfreitas.core.activity.BaseActivity;
import com.jgabrielfreitas.layoutid.annotations.InjectLayout;

import butterknife.Bind;

import static br.com.flip.BuildConfig.MERCHANT_KEY;

@InjectLayout(layout = R.layout.activity_main)
public class MainActivity extends BaseActivity implements CheckoutGrabber {

    @Bind(R.id.connectButton)
    ConnectAuthenticationButton connectButton;


    @Bind(R.id.refreshToken)
    AppCompatButton refreshButton;

    @Bind(R.id.verifyToken)
    AppCompatButton verifyButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Connect.initializer(MERCHANT_KEY, "HOST", "SCHEMA", "CLIENT_SECRET");
    }

    @Override
    protected void onStart() {
        super.onStart();

        connectButton.setAccountCallback(new AccountCallback() {
            @Override
            public void success(OauthToken response) {
                Toast.makeText(MainActivity.this, "login realizado com sucesso", Toast.LENGTH_SHORT).show();

                Log.i("UNIQUE ID", Connect.getInstance().getUniqueId());
            }

            @Override
            public void error(Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });


        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ConnectAuth(v.getContext()).refreshToken(new AccountCallback() {
                    @Override
                    public void success(OauthToken response) {
                        Toast.makeText(MainActivity.this, "refresh realizado com sucesso", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void error(Throwable e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ConnectAuth(v.getContext()).verifyToken(new AccountCallback() {
                    @Override
                    public void success(OauthToken response) {
                        Toast.makeText(MainActivity.this, "verify token realizado com sucesso", Toast.LENGTH_SHORT).show();
                        if (response.hasSuccess()) {
                            Toast.makeText(MainActivity.this, "token valido", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "token invalido", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void error(Throwable e) {
                        e.printStackTrace();
                    }
                });
            }
        });
    }

    @Override
    public Transaction getTransaction() {

        // create your transaction
        Transaction transaction = new Transaction();
        transaction.setTotalAmount(2000);
        transaction.setInstallments(3);
        transaction.setStatementDescriptor("description");
        transaction.setSuccessUrl("https://google.com/");
        return transaction;
    }
}
