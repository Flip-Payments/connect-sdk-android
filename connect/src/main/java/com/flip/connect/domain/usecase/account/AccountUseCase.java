package com.flip.connect.domain.usecase.account;

import com.flip.connect.Connect;
import com.flip.connect.data.model.tempProfile.TempProfile;
import com.flip.connect.data.repository.api.account.AccountManager;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.BaseResponse;
import com.flip.connect.domain.model.account.AccountModel;
import com.flip.connect.domain.model.auth.OauthToken;
import com.flip.connect.domain.model.user.PendingProfile;
import com.flip.connect.domain.repository.AccountRepository;
import com.flip.connect.presentation.categories.Category;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import static com.flip.connect.presentation.categories.Category.emails;
import static com.flip.connect.presentation.categories.Category.phones;
import static com.flip.connect.presentation.categories.Category.publicProfile;

/**
 * Created by Kanda on 13/07/2017.
 */

public class AccountUseCase {
    private AccountRepository manager;

    public AccountUseCase() {
        manager = new AccountManager();
    }

    public void clientInformation(OauthToken token, final CallbackBoundary<AccountModel> callbackBoundary) {
        manager.getAccount(token, new CallbackBoundary<AccountModel>() {
            @Override
            public void success(AccountModel response) {
                if (response == null) {
                    callbackBoundary.error(new Throwable());
                } else {
                    if (response.hasSuccess())
                        callbackBoundary.success(response);
                    else
                        callbackBoundary.error(new Throwable(response.getOperationReport().toString()));
                }
            }

            @Override
            public void error(Throwable e) {
                callbackBoundary.error(e);
            }
        });
    }

    public void updateInformation(OauthToken token, JsonObject update, final CallbackBoundary<BaseResponse> callbackBoundary) {
        manager.update(token, update, callbackBoundary);
    }

    public void savePendingProfile(TempProfile pendingProfile, final CallbackBoundary<PendingProfile> callbackBoundary){
        manager.savePendingProfile(Connect.getInstance().getClientId(), pendingProfile, callbackBoundary);
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
