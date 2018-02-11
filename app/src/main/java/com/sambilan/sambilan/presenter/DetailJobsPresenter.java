package com.sambilan.sambilan.presenter;

import com.sambilan.sambilan.model.ApplyJobBody;
import com.sambilan.sambilan.model.Job;
import com.sambilan.sambilan.model.response.AppliedJobResponse;
import com.sambilan.sambilan.model.response.DetailJobResponse;
import com.sambilan.sambilan.model.response.PostResponse;
import com.sambilan.sambilan.model.response.WaitingPageResponse;
import com.sambilan.sambilan.network.DetailJobsApi;
import com.sambilan.sambilan.network.NetworkService;

import java.util.List;

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
        this.api.getDetailJobs(id).enqueue(new Callback<DetailJobResponse>() {

            @Override
            public void onResponse(Call<DetailJobResponse> call, Response<DetailJobResponse> response) {
                resourcesCallback.OnSuccessResult(response.body().getData());
            }

            @Override
            public void onFailure(Call<DetailJobResponse> call, Throwable t) {
                resourcesCallback.OnFailureResult(t);
            }
        });
    }

    public void applyJob(final ResponseResultCallback<PostResponse<String, Job>, Throwable> applyCallback,
                         final String token,
                         ApplyJobBody body) {

        this.api.applyJob(token, body).enqueue(new Callback<PostResponse<String, Job>>() {
            @Override
            public void onResponse(Call<PostResponse<String, Job>> call, Response<PostResponse<String, Job>> response) {
                applyCallback.OnSuccessResult(response.body());
            }

            @Override
            public void onFailure(Call<PostResponse<String, Job>> call, Throwable t) {
                applyCallback.OnFailureResult(t);
            }
        });
    }

    public void getJobOnWait(final ResponseResultCallback<List<AppliedJobResponse>, Throwable> waitCallback,
                             String token, String status) {
        this.api.getWaitingList(token, status).enqueue(new Callback<WaitingPageResponse>() {
            @Override
            public void onResponse(Call<WaitingPageResponse> call, Response<WaitingPageResponse> response) {
                waitCallback.OnSuccessResult(response.body().getData());
            }

            @Override
            public void onFailure(Call<WaitingPageResponse> call, Throwable t) {
                waitCallback.OnFailureResult(t);
            }
        });
    }

    public interface DetailJobResultCallback<A, B>{
        void OnSuccessResult(A first);
        void OnFailureResult(B second);
    }
}
