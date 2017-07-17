package com.flip.connect.presentation.views.edit;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_edition);
        presenter = new EditPresenter(this);
        presenter.attach(this);
        Category[] categories = (Category[]) getIntent().getExtras().get("CATEGORY");
        presenter.initProfile(categories);
        bindViews();
        imageManager = new ImageManager();
    }

    @Override
    public void showPublicProfile(PublicProfileAccount publicProfile) {
        categoryPublicProfile.setVisibility(View.VISIBLE);
        AppCompatImageView imageProfile = (AppCompatImageView) categoryPublicProfile.findViewById(R.id.imgProfile);
        TextInputLayout name = (TextInputLayout) categoryPublicProfile.findViewById(R.id.publicName);
        if(!publicProfile.getPictureUrl().equals(""))
            imageManager.loadImage(this, publicProfile.getPictureUrl(), imageProfile);

        if(!publicProfile.getName().equals(""))
            name.getEditText().setText(publicProfile.getName());
    }

    @Override
    public void showPersonalData(PersonalDataAccount personalData) {
        categoryPersonalData.setVisibility(View.VISIBLE);
        TextInputLayout birthDate = (TextInputLayout) categoryPersonalData.findViewById(R.id.birthDate);
        TextInputLayout gender = (TextInputLayout) categoryPersonalData.findViewById(R.id.gender);
        TextInputLayout country = (TextInputLayout) categoryPersonalData.findViewById(R.id.country);
        TextInputLayout dependents = (TextInputLayout) categoryPersonalData.findViewById(R.id.dependents);

        if (!personalData.getBirthdate().equals(""))
            birthDate.getEditText().setText(DateFormatUtil.formatDate(personalData.getBirthdate()));

        if (!personalData.getGenderTypeFriendlyName().equals(""))
            gender.getEditText().setText(personalData.getGenderTypeFriendlyName());

        if (!personalData.getCountry().equals(""))
            country.getEditText().setText(personalData.getCountry());

        if (personalData.getDependentCount() != 0)
            dependents.getEditText().setText(personalData.getDependentCount()+"");
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
