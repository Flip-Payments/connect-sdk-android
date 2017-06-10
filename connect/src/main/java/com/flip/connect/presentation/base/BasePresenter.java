package com.flip.connect.presentation.base;

/**
 * Created by jcosilva on 6/9/2017.
 */

public class BasePresenter<T extends BaseViewContract> implements BasePresenterContract<T> {

    private T view;

    @Override
    public void attachView(T baseViewContract) {
        view = baseViewContract;
    }

    @Override
    public void detach() {
        view = null;
    }


    public T getView() {
        if (view == null) {
            throw new NotAttachedException();
        }
        return view;
    }
}
