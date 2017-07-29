package com.flip.connect.domain.model.user;

import com.flip.connect.domain.model.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User extends BaseResponse {

    @SerializedName("emails")
    private List<Email> emails;

    @SerializedName("membershipCreateDate")
    private String membershipCreateDate;

    @SerializedName("isEnabled")
    private boolean isEnabled;

    @SerializedName("personalData")
    private PersonalData personalData;

    @SerializedName("publicProfile")
    private PublicProfile publicProfile;

    @SerializedName("phones")
    private List<Phone> phones;

    @SerializedName("isNewsLetterAllowed")
    private boolean isNewsLetterAllowed;

    @SerializedName("accountKey")
    private String accountKey;

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setMembershipCreateDate(String membershipCreateDate) {
        this.membershipCreateDate = membershipCreateDate;
    }

    public String getMembershipCreateDate() {
        return membershipCreateDate;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public boolean isIsEnabled() {
        return isEnabled;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPublicProfile(PublicProfile publicProfile) {
        this.publicProfile = publicProfile;
    }

    public PublicProfile getPublicProfile() {
        return publicProfile;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setIsNewsLetterAllowed(boolean isNewsLetterAllowed) {
        this.isNewsLetterAllowed = isNewsLetterAllowed;
    }

    public boolean isIsNewsLetterAllowed() {
        return isNewsLetterAllowed;
    }

    public void setAccountKey(String accountKey) {
        this.accountKey = accountKey;
    }

    public String getAccountKey() {
        return accountKey;
    }

    @Override
    public String toString() {
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