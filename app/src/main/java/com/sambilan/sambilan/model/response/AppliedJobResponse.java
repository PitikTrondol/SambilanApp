package com.sambilan.sambilan.model.response;

import com.google.gson.annotations.SerializedName;
import com.sambilan.sambilan.model.Job;

/**
 * Created by Afriandi Haryanto on 2/11/2018.
 */

public class AppliedJobResponse {

    @SerializedName("id")
    private int id;

    @SerializedName("status")
    private String status;

    @SerializedName("rating")
    private String rating;

    @SerializedName("user_detail_id")
    private int userDetailId;

    @SerializedName("job_id")
    private int jobId;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("job")
    private Job job;

    public AppliedJobResponse(int id, String status, String rating, int userDetailId, int jobId, String createdAt, String updatedAt, Job job) {
        this.id = id;
        this.status = status;
        this.rating = rating;
        this.userDetailId = userDetailId;
        this.jobId = jobId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(int userDetailId) {
        this.userDetailId = userDetailId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
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

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
