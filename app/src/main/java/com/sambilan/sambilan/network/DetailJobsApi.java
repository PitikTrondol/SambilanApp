package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.DetailJobResponse;
import com.sambilan.sambilan.model.Job;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by febrian on 04/02/18.
 */

public interface DetailJobsApi {

    @GET("/api/v1/jobs/{id}")
    Call<DetailJobResponse> getDetailJobs(@Path("id") int id);
}
