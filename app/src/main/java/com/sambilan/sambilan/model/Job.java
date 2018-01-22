package com.sambilan.sambilan.model;

/**
 * Created by Afriandi Haryanto on 1/20/2018.
 */

public class Job {
    private int job_id;
    private String job_desc;
    private String job_salary;

    private String company_name;
    private String company_address;
    private String job_created_at;
    private int id_employer;

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
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