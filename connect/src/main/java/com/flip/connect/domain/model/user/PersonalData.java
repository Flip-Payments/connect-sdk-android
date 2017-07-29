package com.flip.connect.domain.model.user;

import com.flip.connect.domain.model.BaseResponse;
import com.google.gson.annotations.SerializedName;

public class PersonalData extends BaseResponse {

    @SerializedName("genderTypeFriendlyName")
    private String genderTypeFriendlyName;

    @SerializedName("country")
    private String country;

    @SerializedName("birthdate")
    private String birthdate;

    @SerializedName("dependentCount")
    private int dependentCount;

    @SerializedName("genderType")
    private String genderType;

    public PersonalData(String country, String birthdate, int dependentCount, String genderType) {
        this.country = country;
        this.birthdate = birthdate;
        this.dependentCount = dependentCount;
        this.genderType = genderType;
    }

    public void setGenderTypeFriendlyName(String genderTypeFriendlyName) {
        this.genderTypeFriendlyName = genderTypeFriendlyName;
    }

    public String getGenderTypeFriendlyName() {
        return genderTypeFriendlyName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setDependentCount(int dependentCount) {
        this.dependentCount = dependentCount;
    }

    public int getDependentCount() {
        return dependentCount;
    }

    public void setGenderType(String genderType) {
        this.genderType = genderType;
    }

    public String getGenderType() {
        return genderType;
    }

    @Override
    public String toString() {
        return
                "PersonalData{" +
                        "genderTypeFriendlyName = '" + genderTypeFriendlyName + '\'' +
                        ",country = '" + country + '\'' +
                        ",birthdate = '" + birthdate + '\'' +
                        ",dependentCount = '" + dependentCount + '\'' +
                        ",genderType = '" + genderType + '\'' +
                        "}";
    }
}