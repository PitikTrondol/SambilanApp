package com.sambilan.sambilan.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by febrian on 01/02/18.
 */

public class EmployeeFlowResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<AppliedJobResponse> data;

    public EmployeeFlowResponse(String status, String message, List<AppliedJobResponse> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AppliedJobResponse> getData() {
        return data;
    }

    public void setData(List<AppliedJobResponse> data) {
        this.data = data;
    }
}
