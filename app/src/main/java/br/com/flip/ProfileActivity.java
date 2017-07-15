package br.com.flip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.user.UserResponse;
import com.flip.connect.presentation.UserData;
import com.flip.connect.presentation.categories.Category;

public class ProfileActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.editButton);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new UserData(ProfileActivity.this).getUserInformation(new CallbackBoundary<UserResponse>() {
            @Override
            public void success(UserResponse response) {
                Glide.with(ProfileActivity.this).load(response.getUser().getPublicProfile().getPictureUrl()).into(imageView);
                recyclerView.setAdapter(new ProfileAdapter(response.getUser()));
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new UserData(ProfileActivity.this).editInformations(Category.emails, Category.phones, Category.publicProfile, Category.personalData);
                    }
                });
            }

            @Override
            public void error(Throwable e) {
                e.printStackTrace();
                Toast.makeText(ProfileActivity.this, "Não foi possível obter as informações do usuário", Toast.LENGTH_LONG).show();
            }
        });
    }
}
