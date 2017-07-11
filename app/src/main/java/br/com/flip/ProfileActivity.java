package br.com.flip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.user.User;
import com.flip.connect.domain.model.user.UserResponse;
import com.flip.connect.presentation.PublicData;

public class ProfileActivity extends AppCompatActivity {

    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name = (EditText) findViewById(R.id.name);
        new PublicData(ProfileActivity.this).getUserInformation(new CallbackBoundary<UserResponse>() {
            @Override
            public void success(UserResponse response) {
                Log.e("user",response.toString());
                name.setText(response.getUser().getPublicProfile().getName());
            }

            @Override
            public void error(Throwable e) {
                e.printStackTrace();
                Toast.makeText(ProfileActivity.this, "Não foi possível obter as informações do usuário", Toast.LENGTH_LONG).show();
            }
        });
    }
}
