package br.com.flip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.user.UserResponse;
import com.flip.connect.presentation.PublicData;

public class ProfileActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        imageView = (ImageView) findViewById(R.id.imageView);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        new PublicData(ProfileActivity.this).getUserInformation(new CallbackBoundary<UserResponse>() {
            @Override
            public void success(UserResponse response) {
                Log.e("user", response.getUser().toString());
                Glide.with(ProfileActivity.this).load(response.getUser().getPublicProfile().getPictureUrl()).into(imageView);
                recyclerView.setAdapter(new ProfileAdapter(response.getUser()));
            }

            @Override
            public void error(Throwable e) {
                e.printStackTrace();
                Toast.makeText(ProfileActivity.this, "Não foi possível obter as informações do usuário", Toast.LENGTH_LONG).show();
            }
        });
    }
}
