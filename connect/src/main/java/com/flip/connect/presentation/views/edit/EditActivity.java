package com.flip.connect.presentation.views.edit;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.flip.connect.R;
import com.flip.connect.domain.model.account.EmailsAccount;
import com.flip.connect.domain.model.account.PersonalDataAccount;
import com.flip.connect.domain.model.account.PhonesAccount;
import com.flip.connect.domain.model.account.PublicProfileAccount;
import com.flip.connect.presentation.categories.Category;
import com.flip.connect.presentation.manager.ImageManager;
import com.flip.connect.presentation.util.DateFormatUtil;

import java.util.List;

public class EditActivity extends AppCompatActivity implements EditContract.View {

    private EditContract.Presenter presenter;
    private RelativeLayout categoryPublicProfile;
    private RelativeLayout categoryPersonalData;
    private RelativeLayout categoryEmail;
    private RelativeLayout categoryPhone;
    private ImageManager imageManager;

    private TextInputLayout birthDate, gender, country, dependents, name;
    private AppCompatImageView imageProfile;
    private RecyclerView emailRecyclerView, phoneRecyclerView;
    private EmailAdapter emailAdapter;
    private PhoneAdapter phoneAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_edition);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        presenter = new EditPresenter(this);
        presenter.attach(this);
        Category[] categories = (Category[]) getIntent().getExtras().get("CATEGORY");
        presenter.initProfile(categories);
        bindViews();
        imageManager = new ImageManager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.OK) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showPublicProfile(PublicProfileAccount publicProfile) {
        categoryPublicProfile.setVisibility(View.VISIBLE);
        if (!publicProfile.getPictureUrl().equals(""))
            imageManager.loadImage(this, publicProfile.getPictureUrl(), imageProfile);

        if (!publicProfile.getName().equals(""))
            name.getEditText().setText(publicProfile.getName());
    }

    @Override
    public void showPersonalData(PersonalDataAccount personalData) {
        categoryPersonalData.setVisibility(View.VISIBLE);

        if (!personalData.getBirthdate().equals(""))
            birthDate.getEditText().setText(DateFormatUtil.formatDate(personalData.getBirthdate()));

        if (!personalData.getGenderTypeFriendlyName().equals(""))
            gender.getEditText().setText(personalData.getGenderTypeFriendlyName());

        if (!personalData.getCountry().equals(""))
            country.getEditText().setText(personalData.getCountry());

        if (personalData.getDependentCount() != 0)
            dependents.getEditText().setText(personalData.getDependentCount() + "");
    }

    @Override
    public void showEmails(List<EmailsAccount> emails) {
        categoryEmail.setVisibility(View.VISIBLE);
        emailAdapter = new EmailAdapter(emails);
        layoutManager = new LinearLayoutManager(this);
        emailRecyclerView.setHasFixedSize(true);
        emailRecyclerView.setLayoutManager(layoutManager);
        emailRecyclerView.setAdapter(emailAdapter);
    }

    @Override
    public void showPhones(List<PhonesAccount> phones) {
        categoryPhone.setVisibility(View.VISIBLE);
        phoneAdapter = new PhoneAdapter(phones);
        layoutManager = new LinearLayoutManager(this);
        phoneRecyclerView.setHasFixedSize(true);
        phoneRecyclerView.setLayoutManager(layoutManager);
        phoneRecyclerView.setAdapter(phoneAdapter);
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void finishView() {
        finish();
    }

    public void bindViews() {
        categoryPublicProfile = (RelativeLayout) findViewById(R.id.categoryPublicProfile);
        categoryPersonalData = (RelativeLayout) findViewById(R.id.categoryPersonalData);
        categoryEmail = (RelativeLayout) findViewById(R.id.categoryEmail);
        categoryPhone = (RelativeLayout) findViewById(R.id.categoryPhone);
        birthDate = (TextInputLayout) categoryPersonalData.findViewById(R.id.birthDate);
        gender = (TextInputLayout) categoryPersonalData.findViewById(R.id.gender);
        country = (TextInputLayout) categoryPersonalData.findViewById(R.id.country);
        dependents = (TextInputLayout) categoryPersonalData.findViewById(R.id.dependents);
        imageProfile = (AppCompatImageView) categoryPublicProfile.findViewById(R.id.imgProfile);
        name = (TextInputLayout) categoryPublicProfile.findViewById(R.id.publicName);
        emailRecyclerView = (RecyclerView) categoryEmail.findViewById(R.id.emails);
        phoneRecyclerView = (RecyclerView) categoryPhone.findViewById(R.id.phones);
    }
}
