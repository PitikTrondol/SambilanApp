package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.response.AdResponse;
import com.sambilan.sambilan.model.response.JobResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by Afriandi Haryanto on 1/20/2018.
 */

public interface LandingPageApi {

    @GET("/api/v1/jobs/")
    Call<JobResponse> getJobLists(@Header("token") String token,
                                  @Query("page") int page,
                                  @Query("limit") int limit);

    @GET("/api/v1/headlines")
    Call<AdResponse> getCarousel();
}
