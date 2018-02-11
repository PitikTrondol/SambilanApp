package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Andhika Putranto on 2/5/2018.
 */

public class UserDetail {
    @SerializedName("id")
    public Integer id;
    @SerializedName("fullname")
    public String fullname;
    @SerializedName("role")
    public String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
