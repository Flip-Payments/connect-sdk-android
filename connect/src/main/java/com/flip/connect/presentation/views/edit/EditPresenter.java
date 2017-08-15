package com.flip.connect.presentation.views.edit;

import android.content.Context;
import android.util.Log;

import com.flip.connect.data.repository.local.LocalDataManager;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.entities.TokenType;
import com.flip.connect.domain.model.BaseResponse;
import com.flip.connect.domain.model.account.AccountModel;
import com.flip.connect.domain.repository.LocalRepository;
import com.flip.connect.domain.usecase.account.AccountUseCase;
import com.flip.connect.presentation.categories.Category;
import com.google.gson.JsonObject;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Kanda on 13/07/2017.
 */

class EditPresenter implements EditContract.Presenter {

    private EditContract.View view;
    private List<Category> categoriesItems;
    private AccountUseCase useCase;
    private LocalRepository localRepository;

    EditPresenter(Context context) {
        useCase = new AccountUseCase();
        localRepository = new LocalDataManager(context);
    }

    @Override
    public void attach(EditContract.View view) {
        this.view = view;
    }

    @Override
    public void initProfile(Category... categories) {
        this.categoriesItems = Arrays.asList(categories);
        if (useCase.intersection(this.categoriesItems, useCase.getCategoriesAccount()).isEmpty() == false) {
            useCase.clientInformation(localRepository.getOauth(TokenType.ACCESS_TOKEN), new CallbackBoundary<AccountModel>() {
                @Override
                public void success(AccountModel response) {
                    for (Category category : categoriesItems) {
                        checkAccountCategories(response, category);
                    }
                }

                @Override
                public void error(Throwable e) {
                    view.toast(e.getMessage());
                    view.finishView();
                }
            });
        }
    }


    private void checkAccountCategories(AccountModel response, Category category) {
        switch (category) {
            case emails:
                view.showEmails(response.account.getEmails());
                break;
            case publicProfile:
                view.showPublicProfile(response.account.getPublicProfile());
                break;
            case phones:
                view.showPhones(response.account.getPhones());
                break;
            case personalData:
                view.showPersonalData(response.account.getPersonalData());
                break;
        }
    }
}
