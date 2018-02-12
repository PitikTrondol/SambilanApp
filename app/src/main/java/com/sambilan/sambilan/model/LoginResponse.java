package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Andhika Putranto on 2/6/2018.
 */

public class LoginResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String email;

    @SerializedName("data")
    private LoginObject loginObject;

    public LoginResponse(String status, String email, LoginObject loginObject) {
        this.status = status;
        this.email = email;
        this.loginObject = loginObject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LoginObject getLoginObject() {
        return loginObject;
    }

    public void setLoginObject(LoginObject loginObject) {
        this.loginObject = loginObject;
    }
}
