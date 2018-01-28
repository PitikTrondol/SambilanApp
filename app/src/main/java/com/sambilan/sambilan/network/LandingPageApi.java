package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.Employer;
import com.sambilan.sambilan.model.JobResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Afriandi Haryanto on 1/20/2018.
 */

public interface LandingPageApi {

    @GET("/jobs")
    Call<JobResponse> getAllJobs();
}
