package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by febrian on 04/02/18.
 */

public class Jobs {

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
    private Date start_due;

    @SerializedName("end_due")
    private Date end_due;

    @SerializedName("expired")
    private Date expired;

    @SerializedName("company_id")
    private int company_id;

    @SerializedName("category_id")
    private int category_id;

    @SerializedName("is_verified")
    private String is_verified;

    @SerializedName("status")
    private String status;

    @SerializedName("created_at")
    private Date created_at;

    @SerializedName("updated_at")
    private Date updated_at;

    @SerializedName("logo_url")
    private String logo_url;

    @SerializedName("company_name")
    private String company_name;

    @SerializedName("company_address")
    private String company_address;

    @SerializedName("count_apply")
    private int count_apply;

    @SerializedName("count_invitation")
    private int count_invitation;

    @SerializedName("seen_count")
    private int seen_count;

    @SerializedName("rating")
    private Float rating;

    public Jobs(){

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

    public Date getStart_due() {
        return start_due;
    }

    public void setStart_due(Date start_due) {
        this.start_due = start_due;
    }

    public Date getEnd_due() {
        return end_due;
    }

    public void setEnd_due(Date end_due) {
        this.end_due = end_due;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
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

    public String getIs_verified() {
        return is_verified;
    }

    public void setIs_verified(String is_verified) {
        this.is_verified = is_verified;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
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

    public int getSeen_count() {
        return seen_count;
    }

    public void setSeen_count(int seen_count) {
        this.seen_count = seen_count;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
