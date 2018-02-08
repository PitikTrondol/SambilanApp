package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.AdResponse;
import com.sambilan.sambilan.model.HomeJobResponse;
import com.sambilan.sambilan.model.JobResponse;
import com.sambilan.sambilan.model.LandingPageResponse;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Afriandi Haryanto on 1/20/2018.
 */

public interface LandingPageApi {

    @GET("/api/v1/jobs/")
    Call<JobResponse> getJobLists(@Query("page") int page,
                                  @Query("limit") int limit);

    @GET("/api/v1/headlines")
    Call<AdResponse> getCarousel();
}
