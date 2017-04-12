package com.flip.connect;

/**
 * Created by JGabrielFreitas on 04/04/17.
 */

public class Flip {

  private String merchantKey;

  private static final Flip instance = new Flip();

  public static Flip getInstance() {
    return instance;
  }

  private Flip() {}

  public static void initalize(String merchantKey) {
    getInstance().merchantKey = merchantKey;
  }

  public static String getMerchantKey() {
    return getInstance().merchantKey;
  }
}
