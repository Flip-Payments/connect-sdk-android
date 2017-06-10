package com.flip.connect.presentation.base;

/**
 * Created by jcosilva on 6/9/2017.
 */

public interface BasePresenterContract<V extends BaseViewContract> {
    void attachView(V baseViewContract);

    void detach();
}
