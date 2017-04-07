package com.flip.connect;

/**
 * Created by JGabrielFreitas on 04/04/17.
 */

public class Flip {

  private static final Flip instance = new Flip();

  public static Flip getInstance() {
    return instance;
  }

  private Flip() {}

}
