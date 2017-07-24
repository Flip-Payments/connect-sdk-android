package br.com.flip;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.flip.connect.Connect;
import com.flip.connect.ConnectConfigurations;
import com.flip.connect.data.model.checkout.Transaction;
import com.flip.connect.domain.boundary.AccountCallback;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.boundary.CheckoutGrabber;
import com.flip.connect.domain.model.auth.OauthToken;
import com.flip.connect.presentation.auth.ConnectAuth;
import com.flip.connect.presentation.widget.ConnectAuthenticationButton;

public class MainActivity extends AppCompatActivity implements CheckoutGrabber {

    ConnectAuthenticationButton connectButton;

    AppCompatButton refreshButton;

    AppCompatButton verifyButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConnectConfigurations config = new ConnectConfigurations();
        config.setClientId("F7F667C7-199F-4A10-B53A-4FADCDFADB53");
        config.setClientSecret("FC3E9D34-978B-483B-9CC0-462DFB82A75B");
        config.setHost("ipiranga");
        config.setSchema("ipiranga");
        config.setPublicToken("4C9E9B38C3EF63AD5AF250611248C226");
        Connect.initializer(config);
        new ConnectAuth(this).verifyToken(new CallbackBoundary<OauthToken>() {
            @Override
            public void success(OauthToken response) {
                if (response.getSuccess()) {
                    startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                    finish();
                }
            }

            @Override
            public void error(Throwable e) {
                e.printStackTrace();
            }
        });
        connectButton = (ConnectAuthenticationButton) findViewById(R.id.connectButton);
        refreshButton = (AppCompatButton) findViewById(R.id.refreshToken);
        verifyButton = (AppCompatButton) findViewById(R.id.verifyToken);
    }

    @Override
    protected void onStart() {
        super.onStart();

        connectButton.setAccountCallback(new AccountCallback() {
            @Override
            public void success(OauthToken response) {
                Toast.makeText(MainActivity.this, "login realizado com sucesso", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                finish();
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
                        if (response.getSuccess()) {
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
