package com.sambilan.sambilan.presenter;

import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.model.response.PostResponse;
import com.sambilan.sambilan.model.response.WaitingPageResponse;
import com.sambilan.sambilan.network.EmployeeFlowAPI;
import com.sambilan.sambilan.network.NetworkService;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Afriandi Haryanto on 2/11/2018.
 */

public class EmployeeFlowPresenter {

    private EmployeeFlowAPI api;

    public EmployeeFlowPresenter() {
        this.api = NetworkService.createEmployeeFlowApi();
    }

    public void getJobByStatus(final ResponseResultCallback<WaitingPageResponse, Throwable> waitingListCallback,
                               String token,
                               String status) {

        this.api.getJobByStatus(token, status).enqueue(new Callback<WaitingPageResponse>() {
            @Override
            public void onResponse(Call<WaitingPageResponse> call, Response<WaitingPageResponse> response) {
                waitingListCallback.OnSuccessResult(response.body());
            }

            @Override
            public void onFailure(Call<WaitingPageResponse> call, Throwable t) {
                waitingListCallback.OnFailureResult(t);
            }
        });
    }

    public void cancelWaitingJob(final ResponseResultCallback<String, Throwable> cancelCallback,
                                 String token,
                                 int jobID) {

        this.api.cancelWaitingJob(token, jobID).enqueue(new Callback<PostResponse<Job>>() {
            @Override
            public void onResponse(Call<PostResponse<Job>> call, Response<PostResponse<Job>> response) {
                cancelCallback.OnSuccessResult(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<PostResponse<Job>> call, Throwable t) {
                cancelCallback.OnFailureResult(t);
            }
        });
    }
}
