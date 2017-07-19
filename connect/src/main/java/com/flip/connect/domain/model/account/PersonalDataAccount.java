package com.flip.connect.domain.model.account;

import com.flip.connect.domain.model.BaseResponse;

public class PersonalDataAccount extends BaseResponse{
	private String genderTypeFriendlyName;
	private String country;
	private String birthdate;
	private int dependentCount;
	private String genderType;

	public void setGenderTypeFriendlyName(String genderTypeFriendlyName){
		this.genderTypeFriendlyName = genderTypeFriendlyName;
	}

	public String getGenderTypeFriendlyName(){
		return genderTypeFriendlyName;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setBirthdate(String birthdate){
		this.birthdate = birthdate;
	}

	public String getBirthdate(){
		return birthdate;
	}

	public void setDependentCount(int dependentCount){
		this.dependentCount = dependentCount;
	}

	public int getDependentCount(){
		return dependentCount;
	}

	public void setGenderType(String genderType){
		this.genderType = genderType;
	}

	public String getGenderType(){
		return genderType;
	}

	@Override
 	public String toString(){
		return 
			"PersonalDataAccount{" +
			"genderTypeFriendlyName = '" + genderTypeFriendlyName + '\'' + 
			",country = '" + country + '\'' + 
			",birthdate = '" + birthdate + '\'' + 
			",dependentCount = '" + dependentCount + '\'' + 
			",genderType = '" + genderType + '\'' + 
			"}";
		}
}
