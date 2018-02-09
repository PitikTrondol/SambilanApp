package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by febrian on 07/02/18.
 */

public class User {

    @SerializedName("id")
    private  int id;

    @SerializedName("fullname")
    private String fullname;

    @SerializedName("id_verified")
    private boolean is_verified;

    @SerializedName("gender")
    private String gender;

    @SerializedName("role")
    private String role;

    @SerializedName("phone")
    private String phone;

    @SerializedName("avatar_url")
    private String avatar_url;

    @SerializedName("address")
    private String address;

    @SerializedName("user_id")
    private int user_id;

    public User(int id, String fullname, boolean is_verified, String gender, String role,
                String phone, String avatar_url, String address, int user_id) {
        this.id = id;
        this.fullname = fullname;
        this.is_verified = is_verified;
        this.gender = gender;
        this.role = role;
        this.phone = phone;
        this.avatar_url = avatar_url;
        this.address = address;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isIs_verified() {
        return is_verified;
    }

    public void setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
