package com.flip.connect.domain.model.account;

import java.util.List;

public class Account{
	private List<EmailsAccount> emails;
	private boolean isEnabled;
	private PersonalDataAccount personalData;
	private PublicProfileAccount publicProfile;
	private List<PhonesAccount> phones;
	private boolean isNewsLetterAllowed;
	private String accountKey;

	public void setEmails(List<EmailsAccount> emails){
		this.emails = emails;
	}

	public List<EmailsAccount> getEmails(){
		return emails;
	}

	public void setIsEnabled(boolean isEnabled){
		this.isEnabled = isEnabled;
	}

	public boolean isIsEnabled(){
		return isEnabled;
	}

	public void setPersonalData(PersonalDataAccount personalData){
		this.personalData = personalData;
	}

	public PersonalDataAccount getPersonalData(){
		return personalData;
	}

	public void setPublicProfile(PublicProfileAccount publicProfile){
		this.publicProfile = publicProfile;
	}

	public PublicProfileAccount getPublicProfile(){
		return publicProfile;
	}

	public void setPhones(List<PhonesAccount> phones){
		this.phones = phones;
	}

	public List<PhonesAccount> getPhones(){
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