package com.flip.connect;

/**
 * Created by JGabrielFreitas on 04/04/17.
 */

public class Flip {

  private static final Flip ourInstance = new Flip();

  public static Flip getInstance() {
    return ourInstance;
  }

  private Flip() {}

}
