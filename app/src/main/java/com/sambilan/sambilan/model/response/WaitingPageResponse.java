package com.sambilan.sambilan.model.response;

import com.google.gson.annotations.SerializedName;
import com.sambilan.sambilan.model.Job;

import java.util.List;

/**
 * Created by febrian on 01/02/18.
 */

public class WaitingPageResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private List<Job> data;

    public WaitingPageResponse(String status, List<Job> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Job> getData() {
        return data;
    }

    public void setData(List<Job> data) {
        this.data = data;
    }

    public class Post {
        @SerializedName("status")
        private String status;

        public Post(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
