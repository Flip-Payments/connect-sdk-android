package com.flip.connect.presentation.views.edit;

import com.flip.connect.domain.boundary.CallbackBoundary;
import com.flip.connect.domain.usecase.edition.EditUseCase;
import com.flip.connect.presentation.categories.Category;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Kanda on 13/07/2017.
 */

public class EditPresenter implements EditContract.Presenter {

    private EditContract.View view;
    private List<Category> categories;
    private EditUseCase useCase;
    public EditPresenter(){
        useCase = new EditUseCase();
    }

    @Override
    public void attach(EditContract.View view) {
        this.view = view;
    }

    @Override
    public void initProfile(Category... categories) {
        this.categories = Arrays.asList(categories);
        useCase.ClientInformations(this.categories, new CallbackBoundary<List<Object>>() {
            @Override
            public void success(List<Object> response) {

            }

            @Override
            public void error(Throwable e) {

            }
        });
    }
}
