package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Andhika Putranto on 2/7/2018.
 */

public class RegisterResponse {
    @SerializedName("status")
    public String status;
    @SerializedName("message")
    public String message;

    public RegisterResponse(){}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
