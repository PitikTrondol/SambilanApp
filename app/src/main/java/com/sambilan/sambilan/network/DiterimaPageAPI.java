package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.model.JobListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Andhika Putranto on 1/31/2018.
 */

public interface DiterimaPageAPI {

    @GET("api/v1/jobs/")
    Call<JobListResponse> getListJobs(@Query("user_detail_id") int id);


}
