package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.JobsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by febrian on 04/02/18.
 */

public interface JobsApi {

    @GET("/api/v1/jobs/")
    Call<JobsResponse> getResources();
}
