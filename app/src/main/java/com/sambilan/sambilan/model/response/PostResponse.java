package com.sambilan.sambilan.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Afriandi Haryanto on 2/11/2018.
 */

public class PostResponse<D> {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private D data;

    public PostResponse(String status, String message, D data) {
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

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }
}
