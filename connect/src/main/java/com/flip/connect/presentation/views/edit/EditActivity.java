package com.flip.connect.presentation.views.edit;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.flip.connect.R;
import com.flip.connect.data.model.Patches;
import com.flip.connect.data.model.UpdateModel;
import com.flip.connect.domain.entities.GenderType;
import com.flip.connect.domain.entities.PersonalDataType;
import com.flip.connect.domain.entities.PublicProfileType;
import com.flip.connect.domain.model.user.Email;
import com.flip.connect.domain.model.user.PersonalData;
import com.flip.connect.domain.model.user.Phone;
import com.flip.connect.domain.model.user.PublicProfile;
import com.flip.connect.presentation.categories.Category;
import com.flip.connect.presentation.manager.ImageManager;
import com.flip.connect.presentation.util.DateFormatUtil;
import com.flip.connect.presentation.util.LocaleUtil;
import com.flip.connect.presentation.util.StringUtil;

import java.util.ArrayList;
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

    private Map<String, View> patches = new HashMap<>();
    private Map<String, Map<String, View>> updates = new HashMap<>();
    private List<String> emailKeys = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_content_edition);
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
    public void showPublicProfile(PublicProfile publicProfile) {
        categoryPublicProfile.setVisibility(View.VISIBLE);
        patches = new HashMap<>();
        patches.put(PublicProfileType.name.toString(), name.getEditText());
        updates.put("publicProfile", patches);
        if (!publicProfile.getPictureUrl().equals(""))
            imageManager.loadImage(this, publicProfile.getPictureUrl(), imageProfile);

        if (!publicProfile.getName().equals(""))
            name.getEditText().setText(publicProfile.getName());
    }

    @Override
    public void showPersonalData(PersonalData personalData) {
        categoryPersonalData.setVisibility(View.VISIBLE);
        patches = new HashMap<>();
        patches.put(PersonalDataType.birthdate.toString(), null);
        patches.put(PersonalDataType.gendertype.toString(), null);
        patches.put(PersonalDataType.country.toString(), null);
        patches.put(PersonalDataType.dependentcount.toString(), null);
        updates.put("personalData", patches);

        if (personalData == null)
            return;

        if (!StringUtil.isEmptyOrNull(personalData.getBirthdate())) {
            birthDate.getEditText().setText(DateFormatUtil.formatDate(personalData.getBirthdate()));
        }

        if (!StringUtil.isEmptyOrNull(personalData.getGenderTypeFriendlyName())) {
            gender.setSelection(GenderType.getPositionFromPT(personalData.getGenderTypeFriendlyName()));
        }

        if (!StringUtil.isEmptyOrNull(personalData.getCountry())) {
            country.setSelection(LocaleUtil.getPositionOfCountry(personalData.getCountry()));
        }

        if (personalData.getDependentCount() != 0) {
            dependents.getEditText().setText(personalData.getDependentCount() + "");
        }

        bindPersonalDataListeners();
    }

    @Override
    public void showEmails(List<Email> emails) {
        categoryEmail.setVisibility(View.VISIBLE);
        EmailAdapter emailAdapter = new EmailAdapter(emails);
        layoutManager = new LinearLayoutManager(this);
        emailRecyclerView.setHasFixedSize(true);
        emailRecyclerView.setLayoutManager(layoutManager);
        emailRecyclerView.setAdapter(emailAdapter);
        //patches = new HashMap<>();
        //patches.put("address", null);
        //updates.put("emails", patches);
        for(int i=0;i<emails.size();i++){

        }
        if (emailAdapter.getLayouts().size() > 0) {

        }
    }

    @Override
    public void showPhones(List<Phone> phones) {
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
        Patches patches;
        UpdateModel updateModel = new UpdateModel();
        String key = "";
        for (Map.Entry<String, Map<String, View>> updateEntry : this.updates.entrySet()) {
            patches = new Patches();
            for (Map.Entry<String, View> patchEntry : updateEntry.getValue().entrySet()) {
                String op;
                String path = "/" + patchEntry.getKey();
                String value = "";

                if (patchEntry.getValue() != null) {
                    if (patchEntry.getValue() instanceof Spinner) {
                        String spinnerContent = ((Spinner) patchEntry.getValue()).getSelectedItem().toString();
                        if (patchEntry.getKey().equals(PersonalDataType.gendertype.toString())) {
                            value = GenderType.getValueFromPT(spinnerContent).toString();
                        } else {
                            value = spinnerContent;
                        }
                    }

                    if (patchEntry.getValue() instanceof TextView) {
                        value = ((TextView) patchEntry.getValue()).getText().toString();
                    }

                    op = value.length() > 0 ? "replace" : "remove";

                    patches.addPatch(op, path, value);
                }
            }

            if (!patches.isNullOrEmpty()) {
                if (StringUtil.isEmptyOrNull(key))
                    updateModel.addToBody(updateEntry.getKey(), patches);
                //else
                    //updateModel.addToBody(updateEntry.getKey(), patches, key);
            }
        }

        presenter.updateProfile(updateModel.getBody());
    }

    private void bindPersonalDataListeners() {
        birthDate.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                patches.put(PersonalDataType.birthdate.toString(), birthDate.getEditText());
            }
        });

        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                patches.put(PersonalDataType.gendertype.toString(), gender);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                patches.put(PersonalDataType.country.toString(), country);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dependents.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                patches.put(PersonalDataType.dependentcount.toString(), dependents.getEditText());
            }
        });
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
