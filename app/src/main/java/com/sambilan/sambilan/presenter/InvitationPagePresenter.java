package com.sambilan.sambilan.presenter;

import com.sambilan.sambilan.model.JobResponse;
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

    public InvitationPagePresenter () {
        this.api = NetworkService.crateInvitationAPI();
    }

    public void getJobInvitation(final ResponseResultCallback<JobResponse, Throwable> resultCallback,
                                 int user_id) {
        this.api.getJobInvitations(user_id).enqueue(new Callback<JobResponse>() {
            @Override
            public void onResponse(Call<JobResponse> call, Response<JobResponse> response) {
                resultCallback.OnSuccessResult(response.body());
            }

            @Override
            public void onFailure(Call<JobResponse> call, Throwable t) {
                resultCallback.OnFailureResult(t);
            }
        });
    }

    //POST
    public String postInvitAction(int user_id, int job_id, String msg) {

        this.api.postInvitationAction(user_id, job_id, msg).enqueue(callback);
        return postResponse;
    }

    private Callback<JSONObject> callback = new Callback<JSONObject>() {
        @Override
        public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
            jsonObject = response.body();
        }

        @Override
        public void onFailure(Call<JSONObject> call, Throwable t) {
            postResponse = t.getMessage();
        }
    };
}
