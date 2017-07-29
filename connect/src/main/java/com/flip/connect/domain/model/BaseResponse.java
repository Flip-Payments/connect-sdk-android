package com.flip.connect.domain.model;

import android.util.Log;

import com.flip.connect.domain.model.auth.OperationReport;

import java.util.List;

/**
 * Created by ltorres on 19/07/2017.
 */

public class BaseResponse {
    private Boolean success = false;
    private List<OperationReport> operationReport;

    public Boolean hasSuccess() {
        return success;
    }

    public List<OperationReport> getOperationReport() {
        return operationReport;
    }

    @Override
    public String toString() {
        String aux = "";
        for(OperationReport or : operationReport){
            aux+=or.getMessage();
        }
        return aux;
    }
}
