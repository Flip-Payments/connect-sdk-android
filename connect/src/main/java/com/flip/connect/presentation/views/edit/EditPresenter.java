package com.flip.connect.presentation.views.edit;

import android.content.Context;
import android.util.Log;

import com.flip.connect.data.model.account.AccountResponse;
import com.flip.connect.data.repository.local.LocalDataManager;
import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.account.Account;
import com.flip.connect.domain.repository.LocalRepository;
import com.flip.connect.domain.usecase.TokenType;
import com.flip.connect.domain.usecase.edition.EditUseCase;
import com.flip.connect.presentation.categories.Category;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Kanda on 13/07/2017.
 */

class EditPresenter implements EditContract.Presenter {

    private EditContract.View view;
    private List<Category> categoriesItems;
    private EditUseCase useCase;
    private LocalRepository localRepository;

    EditPresenter(Context context) {
        useCase = new EditUseCase();
        localRepository = new LocalDataManager(context);
    }

    @Override
    public void attach(EditContract.View view) {
        this.view = view;
    }

    @Override
    public void initProfile(Category... categories) {
        Log.e("opa","opa");
        this.categoriesItems = Arrays.asList(categories);
        if (useCase.intersection(this.categoriesItems, useCase.getCategoriesAccount()).isEmpty() == false) {
            useCase.clientInformation(localRepository.getOauth(TokenType.ACCESS_TOKEN),new CallbackBoundary<AccountResponse>() {
                @Override
                public void success(AccountResponse response) {
                    Log.e("account",response.account.toString());
                    for (Category category : categoriesItems) {
                        checkAccountCategories(response, category);
                    }
                }

                @Override
                public void error(Throwable e) {
                    view.toast("Um erro ocorreu");
                }
            });
        }
    }


    private void checkAccountCategories(AccountResponse response, Category category) {
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
