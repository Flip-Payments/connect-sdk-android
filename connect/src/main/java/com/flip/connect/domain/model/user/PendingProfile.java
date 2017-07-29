package com.flip.connect.domain.model.user;

import com.flip.connect.domain.model.BaseResponse;

/**
 * Created by ltorres on 28/07/2017.
 */

public class PendingProfile extends BaseResponse {
    private String dataKey;

    public String getDataKey() {
        return dataKey;
    }

    public void setDataKey(String dataKey) {
        this.dataKey = dataKey;
    }
}
