package com.flip.connect.domain.model.user;

import com.flip.connect.domain.model.BaseResponse;
import com.google.gson.annotations.SerializedName;

public class PublicProfile extends BaseResponse {

    @SerializedName("pictureUrl")
    private String pictureUrl;

    @SerializedName("name")
    private String name;

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return
                "PublicProfileAccount{" +
                        "pictureUrl = '" + pictureUrl + '\'' +
                        ",name = '" + name + '\'' +
                        "}";
    }
}