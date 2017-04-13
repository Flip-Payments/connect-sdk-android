package com.flip.connect;

import android.content.Context;
import com.jgabrielfreitas.datacontroller.DataController;

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

  public static String getToken() {
    return UserInfo.getInstance().getToken();
  }

  public static void deleteAccountToken(Context context) {
    new DataController(context).remove("account");
  }

}
