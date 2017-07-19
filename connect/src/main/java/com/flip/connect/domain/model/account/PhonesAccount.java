package com.flip.connect.domain.model.account;

import com.flip.connect.domain.model.BaseResponse;

public class PhonesAccount extends BaseResponse{
	private String phoneTypeFriendlyName;
	private String phoneType;
	private boolean isValidated;
	private boolean isPrimary;
	private String key;
	private String fullNumber;

	public void setPhoneTypeFriendlyName(String phoneTypeFriendlyName){
		this.phoneTypeFriendlyName = phoneTypeFriendlyName;
	}

	public String getPhoneTypeFriendlyName(){
		return phoneTypeFriendlyName;
	}

	public void setPhoneType(String phoneType){
		this.phoneType = phoneType;
	}

	public String getPhoneType(){
		return phoneType;
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

	public void setFullNumber(String fullNumber){
		this.fullNumber = fullNumber;
	}

	public String getFullNumber(){
		return fullNumber;
	}

	@Override
 	public String toString(){
		return 
			"PhonesAccount{" +
			"phoneTypeFriendlyName = '" + phoneTypeFriendlyName + '\'' + 
			",phoneType = '" + phoneType + '\'' + 
			",isValidated = '" + isValidated + '\'' + 
			",isPrimary = '" + isPrimary + '\'' + 
			",key = '" + key + '\'' + 
			",fullNumber = '" + fullNumber + '\'' + 
			"}";
		}
}
