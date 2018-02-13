package com.sambilan.sambilan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Andhika Putranto on 2/7/2018.
 */

public class RegisterRequest {
    @SerializedName("email")
    public String email;
    @SerializedName("password")
    public String password;
    @SerializedName("role")
    public String role;
    @SerializedName("gender")
    public String gender;
    @SerializedName("fullname")
    public String fullname;
    @SerializedName("address")
    public String address;
    @SerializedName("phone")
    public String phone;
    @SerializedName("company_name")
    public String company_name;
    @SerializedName("company_address")
    public String company_address;

    public RegisterRequest(String email, String password, String role, String gender, String fullname, String address, String phone, String company_name, String company_address) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.gender = gender;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
        this.company_name = company_name;
        this.company_address = company_address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }
}

