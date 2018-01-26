package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Afriandi Haryanto on 1/20/2018.
 */

public class Job {
    @SerializedName("job_id")
    private int job_id;
    @SerializedName("job_desc")
    private String job_desc;
    @SerializedName("job_title")
    private String job_title;
    @SerializedName("job_salary")
    private String job_salary;

    @SerializedName("company_name")
    private String company_name;
    @SerializedName("company_address")
    private String company_address;
    @SerializedName("job_created_at")
    private String job_created_at;
    @SerializedName("company_id")
    private int id_employer;

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getJob_desc() {
        return job_desc;
    }

    public void setJob_desc(String job_desc) {
        this.job_desc = job_desc;
    }

    public String getJob_salary() {
        return job_salary;
    }

    public void setJob_salary(String job_salary) {
        this.job_salary = job_salary;
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

    public String getJob_created_at() {
        return job_created_at;
    }

    public void setJob_created_at(String job_created_at) {
        this.job_created_at = job_created_at;
    }

    public int getId_employer() {
        return id_employer;
    }

    public void setId_employer(int id_employer) {
        this.id_employer = id_employer;
    }
}