package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Afriandi Haryanto on 2/8/2018.
 */

public class AdResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("messsage")
    private String messsage;

    @SerializedName("headlines")
    private List<Ad> data;

    public AdResponse(String status, String messsage, List<Ad> data) {
        this.status = status;
        this.messsage = messsage;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    public List<Ad> getData() {
        return data;
    }

    public void setData(List<Ad> data) {
        this.data = data;
    }
}
