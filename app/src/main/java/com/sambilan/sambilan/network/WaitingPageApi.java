package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.response.WaitingPageResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by febrian on 01/02/18.
 */

public interface WaitingPageApi {

    @GET("/api/v1/waitingjob/")
    Call<WaitingPageResponse> getWaitingList(@Query("user_detail_id") int user_id);

    @FormUrlEncoded
    @POST("api/v1/invitations/")
    Call<WaitingPageResponse.Post> postWaitingAction(@Field("user_detail_id") int user_id,
                                                     @Field("job_id") int job_id,
                                                     @Field("status") String message);
}
