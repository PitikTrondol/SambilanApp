package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.response.FinishedResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Afriandi Haryanto on 2/9/2018.
 */

public interface FinishedPageAPI {

    @GET("/api/v1/finishedjob/")
    Call<FinishedResponse> getAllFinishedJob (@Query("user_detail_id") int userID);

    @FormUrlEncoded
    @POST("/api/v1/finishedjob/")
    Call<FinishedResponse.Post> postGiveRating(@Field("user_detail_id") int userID,
                                               @Field("job_id") int jobID,
                                               @Field("status") String status);
}
