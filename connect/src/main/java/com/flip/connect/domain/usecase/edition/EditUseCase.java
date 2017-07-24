package com.flip.connect.domain.usecase.edition;

import com.flip.connect.data.model.PatchesBase;
import com.flip.connect.domain.model.account.AccountModel;
import com.flip.connect.data.repository.api.account.AccountManager;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.BaseResponse;
import com.flip.connect.domain.model.auth.OauthToken;
import com.flip.connect.domain.repository.AccountRepository;
import com.flip.connect.presentation.categories.Category;

import java.util.ArrayList;
import java.util.List;

import static com.flip.connect.presentation.categories.Category.emails;
import static com.flip.connect.presentation.categories.Category.phones;
import static com.flip.connect.presentation.categories.Category.publicProfile;

/**
 * Created by Kanda on 13/07/2017.
 */

public class EditUseCase {
    private AccountRepository manager;

    public EditUseCase() {
        manager = new AccountManager();
    }

    public void clientInformation(OauthToken token, final CallbackBoundary<AccountModel> callbackBoundary) {
        manager.getAccount(token, new CallbackBoundary<AccountModel>() {
            @Override
            public void success(AccountModel response) {
                if (response == null) {
                    callbackBoundary.error(new Throwable());
                } else
                    callbackBoundary.success(response);
            }

            @Override
            public void error(Throwable e) {
                callbackBoundary.error(e);
            }
        });
    }

    public void updateInformation(OauthToken token, PatchesBase update, final CallbackBoundary<BaseResponse> callbackBoundary){
        manager.updateAccount(token, update, callbackBoundary);
    }

    public List<Category> getCategoriesAccount() {
        List<Category> categories = new ArrayList<>();
        categories.add(emails);
        categories.add(phones);
        categories.add(publicProfile);
        return categories;
    }

    public <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if (list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }

}
