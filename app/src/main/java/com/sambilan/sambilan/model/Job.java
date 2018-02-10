package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by febrian on 06/02/18.
 */

public class Job {

    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;

    @SerializedName("desc")
    private String desc;

    @SerializedName("capacity")
    private int capacity;

    @SerializedName("salary")
    private String salary;

    @SerializedName("start_due")
    private String start_due;

    @SerializedName("end_due")
    private String end_due;

    @SerializedName("expire_due")
    private String expire_due;

    @SerializedName("company_id")
    private int company_id;

    @SerializedName("category_id")
    private int category_id;

    @SerializedName("is_verified")
    private boolean is_verified;

    @SerializedName("status")
    private String status;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("updated_at")
    private String updated_at;

    @SerializedName("location")
    private String location;

    @SerializedName("category")
    private Category category;

    @SerializedName("company")
    private Company company;

    @SerializedName("count_apply")
    private int count_apply;

    @SerializedName("count_invitation")
    private int count_invitation;

    public Job(int id, String title, String desc, int capacity, String salary,
               String start_due, String end_due, String expire_due, int company_id,
               int category_id, boolean is_verified, String status, String created_at,
               String updated_at, String location, Category category, Company company,
               int count_apply, int count_invitation) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.capacity = capacity;
        this.salary = salary;
        this.start_due = start_due;
        this.end_due = end_due;
        this.expire_due = expire_due;
        this.company_id = company_id;
        this.category_id = category_id;
        this.is_verified = is_verified;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.location = location;
        this.category = category;
        this.company = company;
        this.count_apply = count_apply;
        this.count_invitation = count_invitation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getStart_due() {
        return start_due;
    }

    public void setStart_due(String start_due) {
        this.start_due = start_due;
    }

    public String getEnd_due() {
        return end_due;
    }

    public void setEnd_due(String end_due) {
        this.end_due = end_due;
    }

    public String getExpire_due() {
        return expire_due;
    }

    public void setExpire_due(String expire_due) {
        this.expire_due = expire_due;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public boolean isIs_verified() {
        return is_verified;
    }

    public void setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getCount_apply() {
        return count_apply;
    }

    public void setCount_apply(int count_apply) {
        this.count_apply = count_apply;
    }

    public int getCount_invitation() {
        return count_invitation;
    }

    public void setCount_invitation(int count_invitation) {
        this.count_invitation = count_invitation;
    }
}