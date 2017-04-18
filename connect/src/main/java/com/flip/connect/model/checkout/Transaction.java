package com.flip.connect.model.checkout;

import com.flip.connect.Flip;

/**
 * Created by JGabrielFreitas on 17/04/17.
 */

public class Transaction {

  private String clientId;
  private int    totalAmount;
  private int    installments;
  private String statementDescriptor;
  private String successUrl;

  public Transaction() {
    this.clientId = Flip.getClientId();
  }

  public String getClientId() {
    return clientId;
  }

  public int getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(int totalAmount) {
    this.totalAmount = totalAmount;
  }

  public int getInstallments() {
    return installments;
  }

  public void setInstallments(int installments) {
    this.installments = installments;
  }

  public String getStatementDescriptor() {
    return statementDescriptor;
  }

  public void setStatementDescriptor(String statementDescriptor) {
    this.statementDescriptor = statementDescriptor;
  }

  public String getSuccessUrl() {
    return successUrl;
  }

  public void setSuccessUrl(String successUrl) {
    this.successUrl = successUrl;
  }

  @Override public String toString() {
    return "Transaction{"
        + "clientId='"
        + clientId
        + '\''
        + ", totalAmount='"
        + totalAmount
        + '\''
        + ", installments='"
        + installments
        + '\''
        + ", statementDescriptor='"
        + statementDescriptor
        + '\''
        + ", successUrl='"
        + successUrl
        + '\''
        + '}';
  }
}
