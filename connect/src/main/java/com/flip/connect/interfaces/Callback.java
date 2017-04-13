package com.flip.connect.interfaces;

/**
 * Created by JGabrielFreitas on 12/04/17.
 */

public interface Callback<T> {

  void success(T response);

  void error(Exception e, String message);

}
