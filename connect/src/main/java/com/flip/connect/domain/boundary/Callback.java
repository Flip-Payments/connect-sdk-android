package com.flip.connect.domain.boundary;

/**
 * Created by JGabrielFreitas on 12/04/17.
 */

interface Callback<T> {

  void success(T response);

  void error(Exception e);

}
