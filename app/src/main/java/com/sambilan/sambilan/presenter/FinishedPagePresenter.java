package com.sambilan.sambilan.presenter;

import com.sambilan.sambilan.model.response.FinishedResponse;
import com.sambilan.sambilan.network.FinishedPageAPI;
import com.sambilan.sambilan.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Afriandi Haryanto on 2/9/2018.
 */

public class FinishedPagePresenter {

    private FinishedPageAPI api;

    public FinishedPagePresenter() {
        this.api = NetworkService.createFinishedPageAPI();
    }

    public void getAllFinishedJobs(final ResponseResultCallback<FinishedResponse, Throwable> finishedCallback,
                                   int userID) {

        this.api.getAllFinishedJob(userID)
                .enqueue(new Callback<FinishedResponse>() {
                    @Override
                    public void onResponse(Call<FinishedResponse> call, Response<FinishedResponse> response) {
                        finishedCallback.OnSuccessResult(response.body());
                    }

                    @Override
                    public void onFailure(Call<FinishedResponse> call, Throwable t) {
                        finishedCallback.OnFailureResult(t);
                    }
                });
    }

    public void postBeriPenilaian(final ResponseResultCallback<String, Throwable> penilaianCallback,
                                  int userID,
                                  int jobID,
                                  String rating) {

        this.api.postGiveRating(userID, jobID, rating)
                .enqueue(new Callback<FinishedResponse.Post>() {
                    @Override
                    public void onResponse(Call<FinishedResponse.Post> call, Response<FinishedResponse.Post> response) {
                        penilaianCallback.OnSuccessResult(response.body().getStatus());
                    }

                    @Override
                    public void onFailure(Call<FinishedResponse.Post> call, Throwable t) {
                        penilaianCallback.OnFailureResult(t);
                    }
                });
    }
}
