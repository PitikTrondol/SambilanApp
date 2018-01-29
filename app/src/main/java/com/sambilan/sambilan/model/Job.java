package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Afriandi Haryanto on 1/30/2018.
 */

public class Job {

    @SerializedName("id")
    private int job_id;

    @SerializedName("title")
    private String title;

    @SerializedName("salary")
    private String salary;

    @SerializedName("company_name")
    private String company_name;

    @SerializedName("company_address")
    private String company_address;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("logo_url")
    private String logo_url;

    @SerializedName("company_id")
    private int company_id;

    public Job() {
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }
}
