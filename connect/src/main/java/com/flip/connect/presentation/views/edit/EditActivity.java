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
import com.flip.connect.data.model.UpdateModel;
import com.flip.connect.domain.model.account.EmailsAccount;
import com.flip.connect.domain.model.account.PersonalDataAccount;
import com.flip.connect.domain.model.account.PhonesAccount;
import com.flip.connect.domain.model.account.PublicProfileAccount;
import com.flip.connect.presentation.categories.Category;
import com.flip.connect.presentation.manager.ImageManager;
import com.flip.connect.presentation.util.DateFormatUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditActivity extends AppCompatActivity implements EditContract.View {

    enum personalDataTypes {
        birthdate,
        gendertype,
        dependentcount,
        country
    }

    enum gendersType {
        feminine,
        masculine,
        undefined
    }

    private EditContract.Presenter presenter;
    private RelativeLayout categoryPublicProfile;
    private RelativeLayout categoryPersonalData;
    private RelativeLayout categoryEmail;
    private RelativeLayout categoryPhone;
    private ImageManager imageManager;

    private TextInputLayout birthDate, country, dependents, name;
    private Spinner gender;
    private AppCompatImageView imageProfile;
    private RecyclerView emailRecyclerView, phoneRecyclerView;
    private LinearLayoutManager layoutManager;
    private EmailAdapter emailAdapter;
    private PhoneAdapter phoneAdapter;
    private ArrayAdapter<String> spinnerAdapter;

    private UpdateModel updateModel;

    private Map<String, View> contents = new HashMap<>();
    private Map<String, String> genders = new HashMap<>();

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

        genders.put("Feminino", gendersType.feminine.toString());
        genders.put("Masculino", gendersType.masculine.toString());
        genders.put("Indefinido", gendersType.undefined.toString());

        List<String> list = new ArrayList<>(genders.keySet());
        spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(spinnerAdapter);
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
        contents.put(personalDataTypes.birthdate.toString(), birthDate.getEditText());
        contents.put(personalDataTypes.country.toString(), country.getEditText());
        contents.put(personalDataTypes.gendertype.toString(), gender);
        contents.put(personalDataTypes.dependentcount.toString(), dependents.getEditText());

        if (!personalData.getBirthdate().isEmpty()) {
            birthDate.getEditText().setText(DateFormatUtil.formatDate(personalData.getBirthdate()));
        }

        if (!personalData.getGenderTypeFriendlyName().isEmpty()) {
            gender.setSelection(getIndex(gender, personalData.getGenderTypeFriendlyName()));
        }

        if (personalData.getCountry() != null) {
            if (!personalData.getCountry().isEmpty()) {
                country.getEditText().setText(personalData.getCountry());
            }
        }

        if (personalData.getDependentCount() != 0) {
            dependents.getEditText().setText(personalData.getDependentCount() + "");
        }
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

    private void getContents() {
        updateModel = new UpdateModel();
        for (Map.Entry<String, View> entry : contents.entrySet()) {
            String key = "/".concat(entry.getKey());
            String op = null;
            String value = null;

            if (entry.getValue() instanceof Spinner) {
                op = ((Spinner) entry.getValue()).getSelectedItem().toString().length() > 0 ? "replace" : "remove";
                value = genders.get(((Spinner) entry.getValue()).getSelectedItem().toString());
            }

            if (entry.getValue() instanceof TextView) {
                op = ((TextView) entry.getValue()).getText().toString().length() > 0 ? "replace" : "remove";
                value = ((TextView) entry.getValue()).getText().toString();
            }

            if (!op.isEmpty() && !value.isEmpty()) {
                updateModel.addPatch(op, key, value);
            }

        }

        presenter.updateProfile(updateModel);
    }

    private int getIndex(Spinner spinner, String myString) {

        int index = 0;

        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).equals(myString)) {
                index = i;
            }
        }
        return index;
    }

    public void bindViews() {
        categoryPublicProfile = (RelativeLayout) findViewById(R.id.categoryPublicProfile);
        categoryPersonalData = (RelativeLayout) findViewById(R.id.categoryPersonalData);
        categoryEmail = (RelativeLayout) findViewById(R.id.categoryEmail);
        categoryPhone = (RelativeLayout) findViewById(R.id.categoryPhone);
        birthDate = (TextInputLayout) categoryPersonalData.findViewById(R.id.birthDate);
        gender = (Spinner) categoryPersonalData.findViewById(R.id.gender);
        country = (TextInputLayout) categoryPersonalData.findViewById(R.id.country);
        dependents = (TextInputLayout) categoryPersonalData.findViewById(R.id.dependents);
        imageProfile = (AppCompatImageView) categoryPublicProfile.findViewById(R.id.imgProfile);
        name = (TextInputLayout) categoryPublicProfile.findViewById(R.id.publicName);
        emailRecyclerView = (RecyclerView) categoryEmail.findViewById(R.id.emails);
        phoneRecyclerView = (RecyclerView) categoryPhone.findViewById(R.id.phones);
    }
}
