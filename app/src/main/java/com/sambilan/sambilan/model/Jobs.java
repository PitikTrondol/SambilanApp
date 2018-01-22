package com.sambilan.sambilan.model;

import java.util.List;

/**
 * Created by Afriandi Haryanto on 1/21/2018.
 */

public class Jobs {

    private boolean success;
    private String message;
    private List<Job> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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
