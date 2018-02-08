package com.sambilan.sambilan.presenter;

import com.sambilan.sambilan.model.JobResponse;
import com.sambilan.sambilan.network.DiterimaPageAPI;
import com.sambilan.sambilan.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andhika Putranto on 1/31/2018.
 */

public class ListJobPresenter {

    DiterimaPageAPI api;

    public ListJobPresenter() {
        this.api = NetworkService.createListJobApi();
    }

    public void getListJobs(final ListJobPresenter.JobResultCallback<JobResponse, Throwable> jobCallback, int id) {
//        this.api.getListJobs(id).enqueue(new Callback<JobResponse>() {
//            @Override
//            public void onResponse(Call<JobResponse> call, Response<JobResponse> response) {
//                jobCallback.OnSuccessResult(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<JobResponse> call, Throwable t) {
//                jobCallback.OnFailureResult(t);
//            }
//        });
    }


    public interface JobResultCallback<A, B> {
        void OnSuccessResult(A first);

        void OnFailureResult(B second);
    }
}
