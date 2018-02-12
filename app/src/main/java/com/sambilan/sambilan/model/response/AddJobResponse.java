package com.sambilan.sambilan.model.response;

import com.google.gson.annotations.SerializedName;
import com.sambilan.sambilan.model.Job;

/**
 * Created by febrian on 11/02/18.
 */

public class AddJobResponse {

    @SerializedName("status")
    public String status;

    @SerializedName("message")
    public String message;

    @SerializedName("data")
    public Job data;

    public AddJobResponse(String status, String message, Job data) {
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

    public Job getData() {
        return data;
    }

    public void setData(Job data) {
        this.data = data;
    }
}
