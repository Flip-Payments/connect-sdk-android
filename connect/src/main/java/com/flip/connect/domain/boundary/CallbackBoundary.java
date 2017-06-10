package com.flip.connect.domain.boundary;

/**
 * Created by JGabrielFreitas on 12/04/17.
 */

public interface CallbackBoundary<T> {

  void success(T response);

  void error(Throwable e);

}
