package com.flip.connect.domain.model.account;

public class EmailsAccount {
	private String address;
	private boolean isValidated;
	private boolean isPrimary;
	private String key;

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setIsValidated(boolean isValidated){
		this.isValidated = isValidated;
	}

	public boolean isIsValidated(){
		return isValidated;
	}

	public void setIsPrimary(boolean isPrimary){
		this.isPrimary = isPrimary;
	}

	public boolean isIsPrimary(){
		return isPrimary;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return key;
	}

	@Override
 	public String toString(){
		return 
			"EmailsAccount{" +
			"address = '" + address + '\'' + 
			",isValidated = '" + isValidated + '\'' + 
			",isPrimary = '" + isPrimary + '\'' + 
			",key = '" + key + '\'' + 
			"}";
		}
}
