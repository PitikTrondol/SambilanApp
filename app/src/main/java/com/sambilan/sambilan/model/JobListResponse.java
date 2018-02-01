package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Andhika Putranto on 1/31/2018.
 */

public class JobListResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private List<JobList> data;

    public JobListResponse() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<JobList> getData() {
        return data;
    }

    public void setData(List<JobList> data) {
        this.data = data;
    }
}