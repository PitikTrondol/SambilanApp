package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.HomeJobResponse;
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

<<<<<<< HEAD
    @GET("/api/v1/jobs/")
    Call<LandingPageResponse> getResources(@Query("page") int page,
                                           @Query("limit") int limit);
=======
    @GET("api/v1/landingpage/")
    Call<LandingPageResponse> getResources(@Query("role") String role);

    @GET("api/v1/homejoblist/")
    Call<HomeJobResponse> getJobList(@Query("page") int page,
                                     @Query("itemNum") int itemNum);
>>>>>>> [Afriandi] Add pagination
}
