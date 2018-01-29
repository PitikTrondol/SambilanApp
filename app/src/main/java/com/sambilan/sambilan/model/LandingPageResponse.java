package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Afriandi Haryanto on 1/30/2018.
 */

public class LandingPageResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("joblists")
    private List<JobList> data;

    @SerializedName("headlines")
    private List<Ad> carousels;

    public LandingPageResponse() {
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

    public List<Ad> getCarousels() {
        return carousels;
    }

    public void setCarousels(List<Ad> carousels) {
        this.carousels = carousels;
    }
}
