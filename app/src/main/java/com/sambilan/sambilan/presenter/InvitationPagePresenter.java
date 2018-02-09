package com.sambilan.sambilan.presenter;

import com.sambilan.sambilan.model.response.InvitationResponse;
import com.sambilan.sambilan.model.response.JobResponse;
import com.sambilan.sambilan.network.InvitationPageAPI;
import com.sambilan.sambilan.network.NetworkService;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Afriandi Haryanto on 2/7/2018.
 */

public class InvitationPagePresenter {

    InvitationPageAPI api;
    String postResponse;
    JSONObject jsonObject;

    public InvitationPagePresenter() {
        this.api = NetworkService.crateInvitationAPI();
    }

    public void getJobInvitation(final ResponseResultCallback<InvitationResponse, Throwable> resultCallback,
                                 int user_id) {
        this.api.getJobInvitations(user_id).enqueue(new Callback<InvitationResponse>() {
            @Override
            public void onResponse(Call<InvitationResponse> call, Response<InvitationResponse> response) {
                resultCallback.OnSuccessResult(response.body());
            }

            @Override
            public void onFailure(Call<InvitationResponse> call, Throwable t) {
                resultCallback.OnFailureResult(t);
            }
        });
    }

    //POST
    public void postInvitAction(final ResponseResultCallback<String, Throwable> postCallback,
                                int user_id,
                                int job_id,
                                String msg) {

        this.api.postInvitationAction(user_id, job_id, msg)
                .enqueue(new Callback<InvitationResponse.Post>() {
                    @Override
                    public void onResponse(Call<InvitationResponse.Post> call, Response<InvitationResponse.Post> response) {
                        postCallback.OnSuccessResult(response.body().getStatus());
                    }

                    @Override
                    public void onFailure(Call<InvitationResponse.Post> call, Throwable t) {
                        postCallback.OnFailureResult(t);
                    }
                });
    }
}
