package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.model.response.AddJobResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by febrian on 11/02/18.
 */

public interface AddJobApi {

    @POST("/api/v1/jobs/")
    Call<AddJobResponse> postJob(@Header("token") String token,
                                 @Body Job body);

}

