package com.flip.connect.presentation.views.edit;

import android.util.Log;

import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.model.account.Account;
import com.flip.connect.domain.usecase.edition.EditUseCase;
import com.flip.connect.presentation.categories.Category;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Kanda on 13/07/2017.
 */

public class EditPresenter implements EditContract.Presenter {

    private EditContract.View view;
    private List<Category> categoriesItems;
    private EditUseCase useCase;

    public EditPresenter() {
        useCase = new EditUseCase();
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
            useCase.clientInformation(new CallbackBoundary<Account>() {
                @Override
                public void success(Account response) {
                    Log.e("account",response.toString());
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


    private void checkAccountCategories(Account account, Category category) {
        switch (category) {
            case emails:
                view.showEmails(account.getEmails());
                break;
            case publicProfile:
                view.showPublicProfile(account.getPublicProfile());
                break;
            case phones:
                view.showPhones(account.getPhones());
                break;

            case personalData:
                view.showPersonalData(account.getPersonalData());
                break;
        }
    }
}
