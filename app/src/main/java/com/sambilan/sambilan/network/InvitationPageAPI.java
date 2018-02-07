package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.JobResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Afriandi Haryanto on 2/7/2018.
 */

public interface InvitationPageAPI {

    @GET("api/v1/invitations/")
    Call<JobResponse> getJobInvitations(@Query("userDetailId") int user_id);

    @FormUrlEncoded
    @POST("api/v1/invitations/")
    Call<JSONObject> postInvitationAction(@Field("user_detail_id") int user_id,
                                          @Field("job_id") int job_id,
                                          @Field("message") String message);

}
