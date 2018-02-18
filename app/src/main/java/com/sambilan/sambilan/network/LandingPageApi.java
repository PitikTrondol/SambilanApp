package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.Employee;
import com.sambilan.sambilan.model.response.AdResponse;
import com.sambilan.sambilan.model.response.JobResponse;
import com.sambilan.sambilan.model.response.PostResponse;

import java.util.List;

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

    @GET("/api/v1/jobs/")
    Call<JobResponse> getGuestJoblist(@Query("page") int page, @Query("limit") int limit);

    @GET("/api/v1/headlines")
    Call<AdResponse> getCarousel();

    @GET("api/v1/landing")
    Call<PostResponse<String, List<Employee>>> getEmployee(@Header("token") String token,
                                                           @Query("page") int page,
                                                           @Query("limit") int limit);
}
