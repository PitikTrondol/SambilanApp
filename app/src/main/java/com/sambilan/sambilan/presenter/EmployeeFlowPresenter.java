package com.sambilan.sambilan.presenter;

import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.model.response.PostResponse;
import com.sambilan.sambilan.model.response.EmployeeFlowResponse;
import com.sambilan.sambilan.network.EmployeeFlowAPI;
import com.sambilan.sambilan.network.NetworkService;

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

    public void getJobByStatus(final ResponseResultCallback<EmployeeFlowResponse, Throwable> waitingListCallback,
                               String token,
                               String status) {

        this.api.getJobByStatus(token, status).enqueue(new Callback<EmployeeFlowResponse>() {
            @Override
            public void onResponse(Call<EmployeeFlowResponse> call, Response<EmployeeFlowResponse> response) {
                waitingListCallback.OnSuccessResult(response.body());
            }

            @Override
            public void onFailure(Call<EmployeeFlowResponse> call, Throwable t) {
                waitingListCallback.OnFailureResult(t);
            }
        });
    }

    public void cancelWaitingJob(final ResponseResultCallback<String, Throwable> cancelCallback,
                                 String token,
                                 int jobID) {

        this.api.cancelWaitingJob(token, jobID).enqueue(new Callback<PostResponse<String, Job>>() {
            @Override
            public void onResponse(Call<PostResponse<String, Job>> call, Response<PostResponse<String, Job>> response) {
                cancelCallback.OnSuccessResult(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<PostResponse<String, Job>> call, Throwable t) {
                cancelCallback.OnFailureResult(t);
            }
        });
    }
}
