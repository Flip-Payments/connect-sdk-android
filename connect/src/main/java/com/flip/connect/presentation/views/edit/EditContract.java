package com.flip.connect.presentation.views.edit;

import com.flip.connect.domain.model.user.Email;
import com.flip.connect.domain.model.user.PersonalData;
import com.flip.connect.domain.model.user.Phone;
import com.flip.connect.domain.model.user.PublicProfile;
import com.flip.connect.presentation.categories.Category;
import com.google.gson.JsonObject;

import java.util.List;

/**
 * Created by Kanda on 13/07/2017.
 */

public interface EditContract {

    interface Presenter {

        void attach(View view);

        void initProfile(Category... categories);
    }

    interface View {
        void showPublicProfile(PublicProfile publicProfile);

        void showPersonalData(PersonalData personalData);

        void showEmails(List<Email> emails);

        void showPhones(List<Phone> phones);

        void toast(String msg);

        void finishView();
    }
}
