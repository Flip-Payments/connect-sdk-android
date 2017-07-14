package com.flip.connect.presentation.views.edit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.flip.connect.R;
import com.flip.connect.presentation.categories.Category;

import java.util.List;

public class EditionActivity extends AppCompatActivity implements EditContract.View {

    private EditContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_edition);
        presenter = new EditPresenter();
        presenter.attach(this);
        Category[] categories = (Category[]) getIntent().getExtras().get("CATEGORY");
        presenter.initProfile(categories);
    }

    @Override
    public void showProfile(List<Object> items) {

    }

    @Override
    public void toast(String msg) {

    }
}
