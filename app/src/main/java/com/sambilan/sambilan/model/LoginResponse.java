package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Andhika Putranto on 2/6/2018.
 */

public class LoginResponse {
    @SerializedName("status")
    public String status;
    @SerializedName("id")
    public String id;
    @SerializedName("email")
    public String email;
    @SerializedName("token")
    public String token;
    @SerializedName("user_detail")
    public UserDetail userDetails;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUserDetails(UserDetail userDetails) {
        this.userDetails = userDetails;
    }

    public UserDetail getUserDetails() {
        return userDetails;
    }
}
