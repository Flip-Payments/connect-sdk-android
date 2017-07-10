package com.flip.connect.domain.model.user;

import java.util.List;

public class User{
	private List<EmailsItem> emails;
	private String membershipCreateDate;
	private boolean isEnabled;
	private PersonalData personalData;
	private PublicProfile publicProfile;
	private List<PhonesItem> phones;
	private boolean isNewsLetterAllowed;
	private String accountKey;

	public void setEmails(List<EmailsItem> emails){
		this.emails = emails;
	}

	public List<EmailsItem> getEmails(){
		return emails;
	}

	public void setMembershipCreateDate(String membershipCreateDate){
		this.membershipCreateDate = membershipCreateDate;
	}

	public String getMembershipCreateDate(){
		return membershipCreateDate;
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

	public Object getPersonalData(){
		return personalData;
	}

	public void setPublicProfile(PublicProfile publicProfile){
		this.publicProfile = publicProfile;
	}

	public PublicProfile getPublicProfile(){
		return publicProfile;
	}

	public void setPhones(List<PhonesItem> phones){
		this.phones = phones;
	}

	public List<PhonesItem> getPhones(){
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
			"User{" + 
			"emails = '" + emails + '\'' + 
			",membershipCreateDate = '" + membershipCreateDate + '\'' + 
			",isEnabled = '" + isEnabled + '\'' + 
			",personalData = '" + personalData + '\'' + 
			",publicProfile = '" + publicProfile + '\'' + 
			",phones = '" + phones + '\'' + 
			",isNewsLetterAllowed = '" + isNewsLetterAllowed + '\'' + 
			",accountKey = '" + accountKey + '\'' + 
			"}";
		}
}