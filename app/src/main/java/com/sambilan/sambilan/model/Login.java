package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Andhika Putranto on 2/4/2018.
 */

public class Login {
    @SerializedName("id")
    public int id;
    @SerializedName("avatar_url")
    public String avatar_url;
    @SerializedName("fullname")
    public String fullname;
    @SerializedName("email")
    public String email;
    @SerializedName("role")
    public String role;
    @SerializedName("phone")
    public String phone;
    @SerializedName("skills")
    public List<String> skills;
    @SerializedName("count_applied")
    public int count_applied;
    @SerializedName("rating")
    public float rating;

    public Login() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public int getCount_applied() {
        return count_applied;
    }

    public void setCount_applied(int count_applied) {
        this.count_applied = count_applied;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
