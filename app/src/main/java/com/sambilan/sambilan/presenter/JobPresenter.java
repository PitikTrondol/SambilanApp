package com.sambilan.sambilan.presenter;

import com.sambilan.sambilan.model.Employer;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.model.Jobs;
import com.sambilan.sambilan.network.NetworkService;
import com.sambilan.sambilan.network.JobApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Afriandi Haryanto on 1/21/2018.
 */

public class JobPresenter {

    JobApi api;

    public JobPresenter() {
        this.api = NetworkService.createJobApi();
    }

    public void getJobList(final JobResultCallback jobResultCallbackcallback){
        this.api.getAllJobs().enqueue(new Callback<Jobs>() {
            @Override
            public void onResponse(Call<Jobs> call, Response<Jobs> response) {
                jobResultCallbackcallback.OnSuccessResult(response.body().getData());
            }

            @Override
            public void onFailure(Call<Jobs> call, Throwable t) {
                jobResultCallbackcallback.OnFailureResult(t.getMessage());
            }
        });
    }

    public void getJobOwner(String id, final JobOwnerCallback jobOwnerCallback){
        this.api.getEmployer(id).enqueue(new Callback<Employer>() {
            @Override
            public void onResponse(Call<Employer> call, Response<Employer> response) {
                jobOwnerCallback.OnSuccesResult(response.body());
            }

            @Override
            public void onFailure(Call<Employer> call, Throwable t) {
                jobOwnerCallback.OnFailureResult(t.getMessage());
            }
        });
    }

    public interface JobResultCallback {
        void OnSuccessResult(List<Job> jobs);
        void OnFailureResult(String errorMessage);
    }

    public interface JobOwnerCallback {
        void OnSuccesResult(Employer employer);
        void OnFailureResult(String errorMessage);
    }
}
