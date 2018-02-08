package com.sambilan.sambilan.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Afriandi Haryanto on 2/6/2018.
 */

public class HomeJobResponse {

    @SerializedName("page")
    private Integer page;

    @SerializedName("totalPage")
    private Integer totalPage;

    @SerializedName("itemNum")
    private Integer itemNum;

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("joblists")
    private List<Job> joblists = null;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
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

    public List<Job> getJoblists() {
        return joblists;
    }

    public void setJoblists(List<Job> joblists) {
        this.joblists = joblists;
    }
}
