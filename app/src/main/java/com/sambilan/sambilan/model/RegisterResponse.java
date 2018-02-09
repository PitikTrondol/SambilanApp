package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Andhika Putranto on 2/7/2018.
 */

public class RegisterResponse {
    @SerializedName("status")
    public String status;
    @SerializedName("message")
    public Email message;

    public RegisterResponse(){}
    public Email getMessage() {
        return message;
    }

    public void setMessage(Email message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
