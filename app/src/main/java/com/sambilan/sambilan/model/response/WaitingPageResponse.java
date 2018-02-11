package com.sambilan.sambilan.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by febrian on 01/02/18.
 */

public class WaitingPageResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private List<AppliedJobResponse> data;

    public WaitingPageResponse(String status, List<AppliedJobResponse> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<AppliedJobResponse> getData() {
        return data;
    }

    public void setData(List<AppliedJobResponse> data) {
        this.data = data;
    }
}
