package com.flip.connect.domain.model.user;

import com.flip.connect.domain.model.auth.OperationReport;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {

    @SerializedName("operationReport")
    private List<OperationReport> operationReport;

    @SerializedName("success")
    private boolean success;

    @SerializedName("user")
    private User user;

    public void setOperationReport(List<OperationReport> operationReport) {
        this.operationReport = operationReport;
    }

    public List<OperationReport> getOperationReport() {
        return operationReport;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

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
                        "operationReport = '" + operationReport + '\'' +
                        ",success = '" + success + '\'' +
                        ",user = '" + user + '\'' +
                        "}";
    }
}