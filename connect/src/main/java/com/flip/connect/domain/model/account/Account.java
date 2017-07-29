package com.flip.connect.domain.model.account;

import com.flip.connect.domain.model.BaseResponse;
import com.flip.connect.domain.model.user.Email;
import com.flip.connect.domain.model.user.PersonalData;
import com.flip.connect.domain.model.user.Phone;
import com.flip.connect.domain.model.user.PublicProfile;

import java.util.List;

public class Account extends BaseResponse{
	private List<Email> emails;
	private boolean isEnabled;
	private PersonalData personalData;
	private PublicProfile publicProfile;
	private List<Phone> phones;
	private boolean isNewsLetterAllowed;
	private String accountKey;

	public void setEmails(List<Email> emails){
		this.emails = emails;
	}

	public List<Email> getEmails(){
		return emails;
	}

	public void setIsEnabled(boolean isEnabled){
		this.isEnabled = isEnabled;
	}

	public boolean isIsEnabled(){
		return isEnabled;
	}

	public void setPersonalData(PersonalData personalData){
		this.personalData = personalData;
	}

	public PersonalData getPersonalData(){
		return personalData;
	}

	public void setPublicProfile(PublicProfile publicProfile){
		this.publicProfile = publicProfile;
	}

	public PublicProfile getPublicProfile(){
		return publicProfile;
	}

	public void setPhones(List<Phone> phones){
		this.phones = phones;
	}

	public List<Phone> getPhones(){
		return phones;
	}

	public void setIsNewsLetterAllowed(boolean isNewsLetterAllowed){
		this.isNewsLetterAllowed = isNewsLetterAllowed;
	}

	public boolean isIsNewsLetterAllowed(){
		return isNewsLetterAllowed;
	}

	public void setAccountKey(String accountKey){
		this.accountKey = accountKey;
	}

	public String getAccountKey(){
		return accountKey;
	}

	@Override
 	public String toString(){
		return 
			"Account{" + 
			"emails = '" + emails + '\'' + 
			",isEnabled = '" + isEnabled + '\'' + 
			",personalData = '" + personalData + '\'' + 
			",publicProfile = '" + publicProfile + '\'' + 
			",phones = '" + phones + '\'' + 
			",isNewsLetterAllowed = '" + isNewsLetterAllowed + '\'' + 
			",accountKey = '" + accountKey + '\'' +
			"}";
		}
}