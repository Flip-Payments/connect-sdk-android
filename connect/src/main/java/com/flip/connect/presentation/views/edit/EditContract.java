package com.flip.connect.presentation.views.edit;

import com.flip.connect.data.model.UpdateModel;
import com.flip.connect.data.model.account.AccountModel;
import com.flip.connect.domain.model.account.EmailsAccount;
import com.flip.connect.domain.model.account.PersonalDataAccount;
import com.flip.connect.domain.model.account.PhonesAccount;
import com.flip.connect.domain.model.account.PublicProfileAccount;
import com.flip.connect.presentation.categories.Category;

import java.util.List;

/**
 * Created by Kanda on 13/07/2017.
 */

public interface EditContract {

    interface Presenter {

        void attach(View view);

        void initProfile(Category... categories);

        void updateProfile(UpdateModel updateModel);
    }

    interface View {
        void showPublicProfile(PublicProfileAccount publicProfile);

        void showPersonalData(PersonalDataAccount personalData);

        void showEmails(List<EmailsAccount> emails);

        void showPhones(List<PhonesAccount> phones);

        void toast(String msg);

        void finishView();
    }
}
