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
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.flip.connect.R;
import com.flip.connect.data.model.PatchesBase;
import com.flip.connect.domain.entities.GenderType;
import com.flip.connect.domain.entities.PersonalDataType;
import com.flip.connect.domain.model.account.EmailsAccount;
import com.flip.connect.domain.model.account.PersonalDataAccount;
import com.flip.connect.domain.model.account.PhonesAccount;
import com.flip.connect.domain.model.account.PublicProfileAccount;
import com.flip.connect.presentation.categories.Category;
import com.flip.connect.presentation.manager.ImageManager;
import com.flip.connect.presentation.util.DateFormatUtil;
import com.flip.connect.presentation.util.LocaleUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditActivity extends AppCompatActivity implements EditContract.View {
    private EditContract.Presenter presenter;
    private RelativeLayout categoryPublicProfile;
    private RelativeLayout categoryPersonalData;
    private RelativeLayout categoryEmail;
    private RelativeLayout categoryPhone;
    private ImageManager imageManager;

    private TextInputLayout birthDate, dependents, name;
    private Spinner gender, country;
    private AppCompatImageView imageProfile;
    private RecyclerView emailRecyclerView, phoneRecyclerView;
    private LinearLayoutManager layoutManager;

    private Map<String, View> contents = new HashMap<>();

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

        //TODO Change gendertype to API response
        ArrayAdapter<String> genderSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, GenderType.getValuesPT());
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(genderSpinnerAdapter);

        ArrayAdapter<String> countrySpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, LocaleUtil.getAllCountryAvailable());
        countrySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country.setAdapter(countrySpinnerAdapter);
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
            getContents();
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
        contents.put(PersonalDataType.birthdate.toString(), birthDate.getEditText());
        contents.put(PersonalDataType.country.toString(), country);
        contents.put(PersonalDataType.gendertype.toString(), gender);
        contents.put(PersonalDataType.dependentcount.toString(), dependents.getEditText());

        if (!personalData.getBirthdate().isEmpty()) {
            birthDate.getEditText().setText(DateFormatUtil.formatDate(personalData.getBirthdate()));
        }

        if (!personalData.getGenderTypeFriendlyName().isEmpty()) {
            gender.setSelection(GenderType.getPositionFromPT(personalData.getGenderTypeFriendlyName()));
        }

        if (!personalData.getCountry().isEmpty()) {
            country.setSelection(LocaleUtil.getPositionOfCountry(personalData.getCountry()));
        }

        if (personalData.getDependentCount() != 0) {
            dependents.getEditText().setText(personalData.getDependentCount() + "");
        }
    }

    @Override
    public void showEmails(List<EmailsAccount> emails) {
        categoryEmail.setVisibility(View.VISIBLE);
        EmailAdapter emailAdapter = new EmailAdapter(emails);
        layoutManager = new LinearLayoutManager(this);
        emailRecyclerView.setHasFixedSize(true);
        emailRecyclerView.setLayoutManager(layoutManager);
        emailRecyclerView.setAdapter(emailAdapter);
    }

    @Override
    public void showPhones(List<PhonesAccount> phones) {
        categoryPhone.setVisibility(View.VISIBLE);
        PhoneAdapter phoneAdapter = new PhoneAdapter(phones);
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

    private void getContents() {
        PatchesBase patchesBase = new PatchesBase();
        for (Map.Entry<String, View> entry : contents.entrySet()) {
            String op;
            String key = "/".concat(entry.getKey());
            String value = "";

            if (entry.getValue() instanceof Spinner) {
                String spinnerContent = ((Spinner) entry.getValue()).getSelectedItem().toString();
                if (entry.getKey().equals(PersonalDataType.gendertype.toString())) {
                    value = GenderType.getValueFromPT(spinnerContent).toString();
                } else {
                    value = spinnerContent;
                }
            }

            if (entry.getValue() instanceof TextView) {
                value = ((TextView) entry.getValue()).getText().toString();
            }

            op = value.length() > 0 ? "replace" : "remove";

            patchesBase.addPatch(op, key, value);
        }

        presenter.updateProfile(patchesBase);
    }

    public void bindViews() {
        categoryPublicProfile = (RelativeLayout) findViewById(R.id.categoryPublicProfile);
        categoryPersonalData = (RelativeLayout) findViewById(R.id.categoryPersonalData);
        categoryEmail = (RelativeLayout) findViewById(R.id.categoryEmail);
        categoryPhone = (RelativeLayout) findViewById(R.id.categoryPhone);
        birthDate = (TextInputLayout) categoryPersonalData.findViewById(R.id.birthDate);
        gender = (Spinner) categoryPersonalData.findViewById(R.id.gender);
        country = (Spinner) categoryPersonalData.findViewById(R.id.country);
        dependents = (TextInputLayout) categoryPersonalData.findViewById(R.id.dependents);
        imageProfile = (AppCompatImageView) categoryPublicProfile.findViewById(R.id.imgProfile);
        name = (TextInputLayout) categoryPublicProfile.findViewById(R.id.publicName);
        emailRecyclerView = (RecyclerView) categoryEmail.findViewById(R.id.emails);
        phoneRecyclerView = (RecyclerView) categoryPhone.findViewById(R.id.phones);
    }
}
