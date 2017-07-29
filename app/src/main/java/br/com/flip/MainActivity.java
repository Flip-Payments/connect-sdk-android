package br.com.flip;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Toast;

import com.flip.connect.Connect;
import com.flip.connect.ConnectConfigurations;
import com.flip.connect.data.model.tempProfile.TempProfile;
import com.flip.connect.data.model.checkout.Transaction;
import com.flip.connect.domain.boundary.AccountCallback;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.boundary.CheckoutGrabber;
import com.flip.connect.domain.model.auth.OauthToken;
import com.flip.connect.domain.model.user.Address;
import com.flip.connect.domain.model.user.Document;
import com.flip.connect.domain.model.user.Email;
import com.flip.connect.domain.model.user.PersonalData;
import com.flip.connect.domain.model.user.Phone;
import com.flip.connect.domain.model.user.Vehicle;
import com.flip.connect.presentation.auth.ConnectAuth;
import com.flip.connect.presentation.widget.ConnectAuthenticationButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CheckoutGrabber {

    ConnectAuthenticationButton connectButton;

    AppCompatButton refreshButton;

    AppCompatButton verifyButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConnectConfigurations config = new ConnectConfigurations();
        config.setClientId("CLIENTID");
        config.setClientSecret("CLIENTSECRET");
        config.setHost("HOST");
        config.setSchema("SCHEMA");
        config.setPublicToken("PUBLICTOKEN");
        config.setFingerPrintID("FINGERPRINT");

        config.setTempProfile(feedTempProfile()); // READ THE DOCUMENTATION

        Connect.initializer(config);
        new ConnectAuth(this).verifyToken(new CallbackBoundary<OauthToken>() {
            @Override
            public void success(OauthToken response) {
                if (response.hasSuccess()) {
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

    private TempProfile feedTempProfile(){
        PersonalData personalData = new PersonalData("BR", "12/05/1997", 2, "masculine");

        Vehicle vehicle =new Vehicle("BBB 1234", null, "RJ", "BR");
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle);

        Address address = new Address("Rua Sem nome", "200", "ap 101", "work", "Ipanema", "Rio de Janeiro", "RJ", "22220-000", "perto do banco", "brasil");
        List<Address> addresses = new ArrayList<>();
        addresses.add(address);

        Phone phone = new Phone("mobile", "+5521998766574");
        List<Phone> phones = new ArrayList<>();
        phones.add(phone);

        Document document = new Document("cpf", "23989146408");
        List<Document> documents = new ArrayList<>();
        documents.add(document);

        Email email = new Email("connect@gmail.com");
        List<Email> emails = new ArrayList<>();
        emails.add(email);
        return new TempProfile(personalData, vehicles, addresses, phones, documents, emails);
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
