package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Andhika Putranto on 1/31/2018.
 */

public class JobResponse {

    @SerializedName("status")
    public String status;

    @SerializedName("data")
    public List<Job> data;

    public JobResponse() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Job> getData() {
        return data;
    }

    public void setData(List<Job> data) {
        this.data = data;
    }
}