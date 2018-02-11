package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.ApplyJobBody;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.model.response.DetailJobResponse;
import com.sambilan.sambilan.model.response.PostResponse;
import com.sambilan.sambilan.model.response.WaitingPageResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by febrian on 04/02/18.
 */

public interface DetailJobsApi {

    @GET("/api/v1/jobs/{id}")
    Call<DetailJobResponse> getDetailJobs(@Path("id") int id);

    @POST("/api/v1/applies/")
    Call<PostResponse<String, Job>> applyJob(@Header("token") String token,
                                             @Body ApplyJobBody body);

    @GET("/api/v1/applies/")
    Call<WaitingPageResponse> getWaitingList(@Header("token") String token,
                                             @Query("status") String status);
}
