package com.flip.connect;

/**
 * Created by JGabrielFreitas on 12/04/17.
 */

class UserInfo {

  private static final UserInfo instance = new UserInfo();
  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  static UserInfo getInstance() {
    return instance;
  }

  private UserInfo() {
  }
}
