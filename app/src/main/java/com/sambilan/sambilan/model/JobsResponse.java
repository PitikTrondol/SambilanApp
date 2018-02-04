package com.sambilan.sambilan.model;

import java.util.List;

/**
 * Created by febrian on 04/02/18.
 */

public class JobsResponse {

    private List<Jobs> data;

    public JobsResponse(){

    }

    public List<Jobs> getData() {
        return data;
    }

    public void setData(List<Jobs> data) {
        this.data = data;
    }
}
