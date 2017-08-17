package br.com.flip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.flip.connect.domain.boundary.AccountCallback;
import com.flip.connect.domain.model.auth.OauthToken;
import com.flip.connect.presentation.auth.ConnectAuth;
import com.flip.connect.presentation.views.login.LoginActivity;

public class ProfileActivity extends AppCompatActivity {


    ImageView imageView;
    Button btnRevokeToken;
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView = (ImageView) findViewById(R.id.imageView);

        btnRevokeToken = (Button) findViewById(R.id.btn_revoke_token);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnRevokeToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ConnectAuth(ProfileActivity.this).revokeToken(new AccountCallback() {
                    @Override
                    public void success(OauthToken response) {
                        Toast.makeText(ProfileActivity.this, "revoke realizado com sucesso", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                        finish();
                    }

                    @Override
                    public void error(Throwable e) {
                        Toast.makeText(ProfileActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                });
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
    }
}
