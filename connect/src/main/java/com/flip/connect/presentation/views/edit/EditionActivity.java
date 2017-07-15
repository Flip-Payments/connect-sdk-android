package com.flip.connect.presentation.views.edit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.flip.connect.R;
import com.flip.connect.domain.model.account.EmailsAccount;
import com.flip.connect.domain.model.account.PersonalDataAccount;
import com.flip.connect.domain.model.account.PhonesAccount;
import com.flip.connect.domain.model.account.PublicProfileAccount;
import com.flip.connect.presentation.categories.Category;

import java.util.List;

public class EditionActivity extends AppCompatActivity implements EditContract.View {

    private EditContract.Presenter presenter;
    private RelativeLayout categoryPublicProfile;
    private RelativeLayout categoryPersonalData;
    private RelativeLayout categoryEmail;
    private RelativeLayout categoryPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_edition);
        presenter = new EditPresenter();
        presenter.attach(this);
        Category[] categories = (Category[]) getIntent().getExtras().get("CATEGORY");
        presenter.initProfile(categories);
        bindViews();
    }

    @Override
    public void showPublicProfile(PublicProfileAccount publicProfile) {
        categoryPublicProfile.setVisibility(View.VISIBLE);
    }

    @Override
    public void showPersonalData(PersonalDataAccount personalData) {
        categoryPersonalData.setVisibility(View.VISIBLE);
    }

    @Override
    public void showEmails(List<EmailsAccount> emails) {
        categoryEmail.setVisibility(View.VISIBLE);
    }

    @Override
    public void showPhones(List<PhonesAccount> phones) {
        categoryPhone.setVisibility(View.VISIBLE);
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(getBaseContext(), "Tente editar seu perfil novamente mais tarde", Toast.LENGTH_LONG).show();
    }

    public void bindViews() {
        categoryPublicProfile = (RelativeLayout) findViewById(R.id.categoryPublicProfile);
        categoryPersonalData = (RelativeLayout) findViewById(R.id.categoryPersonalData);
        categoryEmail = (RelativeLayout) findViewById(R.id.categoryEmail);
        categoryPhone = (RelativeLayout) findViewById(R.id.categoryPhone);
    }
}
