package com.sambilan.sambilan.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Afriandi Haryanto on 2/11/2018.
 */

public class PostResponse<M, D> {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private M message;

    @SerializedName("data")
    private D data;

    public PostResponse(String status, M message, D data) {
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

    public M getMessage() {
        return message;
    }

    public void setMessage(M message) {
        this.message = message;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }
}
