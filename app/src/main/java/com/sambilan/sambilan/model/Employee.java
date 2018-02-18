package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Afriandi Haryanto on 2/12/2018.
 */

public class Employee {

    @SerializedName("id")
    private int id;
    @SerializedName("fullname")
    private String fullname;
    @SerializedName("is_verified")
    private boolean isVerified;
    @SerializedName("gender")
    private String gender;
    @SerializedName("role")
    private String role;
    @SerializedName("phone")
    private String phone;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("address")
    private String address;
    @SerializedName("user_id")
    private Integer userId;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("email")
    private String email;

    public Employee(int id, String fullname, boolean isVerified, String gender, String role, String phone, String avatarUrl, String address, Integer userId, String createdAt, String updatedAt, String email) {
        this.id = id;
        this.fullname = fullname;
        this.isVerified = isVerified;
        this.gender = gender;
        this.role = role;
        this.phone = phone;
        this.avatarUrl = avatarUrl;
        this.address = address;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.email = email;
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

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
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

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
