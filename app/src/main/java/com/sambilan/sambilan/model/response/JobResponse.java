package com.sambilan.sambilan.model.response;

import com.google.gson.annotations.SerializedName;
import com.sambilan.sambilan.model.Job;

import java.util.List;

/**
 * Created by Andhika Putranto on 1/31/2018.
 */

public class JobResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<Job> data;

    @SerializedName("current_page")
    private int currentPage;

    @SerializedName("limit_page")
    private int limitPage;

    @SerializedName("total_page")
    private int totalPage;

    @SerializedName("total_jobs")
    private int totalJobs;

    public JobResponse(String status, String message, List<Job> data, int currentPage, int limitPage, int totalPage, int totalJobs) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.currentPage = currentPage;
        this.limitPage = limitPage;
        this.totalPage = totalPage;
        this.totalJobs = totalJobs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Job> getData() {
        return data;
    }

    public void setData(List<Job> data) {
        this.data = data;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getLimitPage() {
        return limitPage;
    }

    public void setLimitPage(int limitPage) {
        this.limitPage = limitPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalJobs() {
        return totalJobs;
    }

    public void setTotalJobs(int totalJobs) {
        this.totalJobs = totalJobs;
    }
}