package com.flip.connect.presentation.views.edit;

import com.flip.connect.presentation.categories.Category;

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

        void showProfile(List<Object> items);
        void toast(String msg);
    }
}
