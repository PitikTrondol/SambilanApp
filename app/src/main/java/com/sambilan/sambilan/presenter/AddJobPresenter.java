package com.sambilan.sambilan.presenter;

import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.model.response.AddJobResponse;
import com.sambilan.sambilan.network.AddJobApi;
import com.sambilan.sambilan.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by febrian on 11/02/18.
 */

public class AddJobPresenter {

    AddJobApi api;

    public AddJobPresenter(){
        this.api = NetworkService.createAddJobApi();
    }

    public void postingJob(final ResponseResultCallback<AddJobResponse, Throwable> postJobCallback,
                           final String token,
                           Job body){
        this.api.postJob(token, body).enqueue(new Callback<AddJobResponse>() {
            @Override
            public void onResponse(Call<AddJobResponse> call, Response<AddJobResponse> response) {
                postJobCallback.OnSuccessResult(response.body());
            }

            @Override
            public void onFailure(Call<AddJobResponse> call, Throwable t) {
                postJobCallback.OnFailureResult(t);
            }
        });
    }

}
