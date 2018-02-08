package com.sambilan.sambilan.presenter;

import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.network.DetailJobsApi;
import com.sambilan.sambilan.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by febrian on 04/02/18.
 */

public class DetailJobsPresenter {

    DetailJobsApi api;

    public DetailJobsPresenter(){
        this.api = NetworkService.createJobsApi();
    }

    public void getDetailJob(final DetailJobResultCallback<Job, Throwable> resourcesCallback , int id){
        this.api.getDetailJobs(id).enqueue(new Callback<Job>() {
            @Override
            public void onResponse(Call<Job> call, Response<Job> response) {
                resourcesCallback.OnSuccessResult(response.body());
            }

            @Override
            public void onFailure(Call<Job> call, Throwable t) {
                resourcesCallback.OnFailureResult(t);
            }
        });
    }

    public interface DetailJobResultCallback<A, B>{
        void OnSuccessResult(A first);
        void OnFailureResult(B second);
    }
}