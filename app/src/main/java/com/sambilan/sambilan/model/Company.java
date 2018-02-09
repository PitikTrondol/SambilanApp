package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by febrian on 07/02/18.
 */

public class Company {

    @SerializedName("id")
    public int id;

    @SerializedName("user_detail_id")
    public int user_detail_id;

    @SerializedName("name")
    public String name;

    @SerializedName("address")
    public String address;

    @SerializedName("desc")
    public String desc;

    @SerializedName("logo_url")
    public String logo_url;

    @SerializedName("is_verified")
    public String is_verified;

    @SerializedName("user_detail")
    public User user_detail;

    public Company(int id, int user_detail_id, String name,
                   String address, String desc, String logo_url,
                   String is_verified, User user_detail) {
        this.id = id;
        this.user_detail_id = user_detail_id;
        this.name = name;
        this.address = address;
        this.desc = desc;
        this.logo_url = logo_url;
        this.is_verified = is_verified;
        this.user_detail = user_detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_detail_id() {
        return user_detail_id;
    }

    public void setUser_detail_id(int user_detail_id) {
        this.user_detail_id = user_detail_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public String getIs_verified() {
        return is_verified;
    }

    public void setIs_verified(String is_verified) {
        this.is_verified = is_verified;
    }

    public User getUser_detail() {
        return user_detail;
    }

    public void setUser_detail(User user_detail) {
        this.user_detail = user_detail;
    }
}
