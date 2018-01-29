package com.sambilan.sambilan.presenter;

import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.model.JobResponse;
import com.sambilan.sambilan.network.NetworkService;
import com.sambilan.sambilan.network.LandingPageApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Afriandi Haryanto on 1/21/2018.
 */

public class LandingPagePresenter {

    LandingPageApi api;

    public LandingPagePresenter() {
        this.api = NetworkService.createLandingPageApi();
    }

    public void getJobList(final JobResultCallback<JobResponse, Throwable> jobResultCallbackcallback){
        this.api.getAllJobs().enqueue(new Callback<JobResponse>() {
            @Override
            public void onResponse(Call<JobResponse> call, Response<JobResponse> response) {
                jobResultCallbackcallback.OnSuccessResult(response.body());
            }

            @Override
            public void onFailure(Call<JobResponse> call, Throwable t) {
                jobResultCallbackcallback.OnFailureResult(t);
            }
        });
    }

    public interface JobResultCallback<A, B> {
        void OnSuccessResult(A first);
        void OnFailureResult(B second);
    }
}
