package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.model.response.PostResponse;
import com.sambilan.sambilan.model.response.WaitingPageResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Afriandi Haryanto on 2/11/2018.
 */

public interface EmployeeFlowAPI {

    @GET("/api/v1/applies/")
    Call<WaitingPageResponse> getJobByStatus(@Header("token") String token,
                                             @Query("status") String status);

    @DELETE("/api/v1/applies/{id}")
    Call<PostResponse<String, Job>> cancelWaitingJob(@Header("token") String token,
                                                     @Path("id") int id);
}
