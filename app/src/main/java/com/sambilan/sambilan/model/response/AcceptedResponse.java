package com.sambilan.sambilan.model.response;

import com.google.gson.annotations.SerializedName;
import com.sambilan.sambilan.model.Job;

import java.util.List;

/**
 * Created by Afriandi Haryanto on 2/9/2018.
 */

public class AcceptedResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<Job> data;

<<<<<<< HEAD:app/src/main/java/com/sambilan/sambilan/model/LandingPageResponse.java
    public LandingPageResponse(String status, String message, List<Job> data) {
=======
    public AcceptedResponse(String status, String message, List<Job> data) {
>>>>>>> develop:app/src/main/java/com/sambilan/sambilan/model/response/AcceptedResponse.java
        this.status = status;
        this.message = message;
        this.data = data;
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
}
