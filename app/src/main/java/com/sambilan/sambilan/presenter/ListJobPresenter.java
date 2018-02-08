package com.sambilan.sambilan.presenter;

import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.model.JobListResponse;
import com.sambilan.sambilan.model.LandingPageResponse;
import com.sambilan.sambilan.network.LandingPageApi;
import com.sambilan.sambilan.network.ListJobAPI;
import com.sambilan.sambilan.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andhika Putranto on 1/31/2018.
 */

public class ListJobPresenter {

    ListJobAPI api;

    public ListJobPresenter() {
        this.api = NetworkService.createListJobApi();
    }

    public void getListJobs(final ListJobPresenter.JobResultCallback<JobListResponse, Throwable> jobCallback,int id) {
        this.api.getListJobs(id).enqueue(new Callback<JobListResponse>() {
            @Override
            public void onResponse(Call<JobListResponse> call, Response<JobListResponse> response) {
                jobCallback.OnSuccessResult(response.body());
            }

            @Override
            public void onFailure(Call<JobListResponse> call, Throwable t) {
                jobCallback.OnFailureResult(t);
            }
        });
    }


    public interface JobResultCallback<A, B> {
        void OnSuccessResult(A first);

        void OnFailureResult(B second);
    }
}
