package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by febrian on 01/02/18.
 */

public class WaitingPageResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("joblists")
    private List<Job> data;

    public WaitingPageResponse(){

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
