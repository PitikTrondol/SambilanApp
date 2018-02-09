package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.LandingPageResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Afriandi Haryanto on 1/20/2018.
 */

public interface LandingPageApi {

//    @GET("/jobs")
//    Call<JobResponse> getAllJobs();

    @GET("/api/v1/landingpage/")
    Call<LandingPageResponse> getResources(@Query("role") String role);
}
