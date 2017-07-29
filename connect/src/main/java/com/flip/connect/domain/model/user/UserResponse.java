package com.flip.connect.domain.model.user;

import com.flip.connect.domain.model.BaseResponse;
import com.google.gson.annotations.SerializedName;

public class UserResponse extends BaseResponse {

    @SerializedName("user")
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return
                "UserResponse{" +
                        "operationReport = '" + getOperationReport() + '\'' +
                        ",success = '" + hasSuccess() + '\'' +
                        ",user = '" + user + '\'' +
                        "}";
    }
}