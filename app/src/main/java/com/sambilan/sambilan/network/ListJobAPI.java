package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.model.JobList;
import com.sambilan.sambilan.model.JobListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Andhika Putranto on 1/31/2018.
 */

public interface ListJobAPI {

    @GET("/api/v1/acceptedjob/")
    Call<JobListResponse> getListJobs(@Query("user_detail_id") int id);


}
