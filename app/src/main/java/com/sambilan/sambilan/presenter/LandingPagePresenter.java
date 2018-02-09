package com.sambilan.sambilan.presenter;

import com.sambilan.sambilan.model.response.AdResponse;
import com.sambilan.sambilan.model.response.JobResponse;
import com.sambilan.sambilan.network.NetworkService;
import com.sambilan.sambilan.network.LandingPageApi;

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

    public void getHomeCarousel(final ResponseResultCallback<AdResponse, Throwable> carouselCallback) {
        this.api.getCarousel()
                .enqueue(new Callback<AdResponse>() {
                    @Override
                    public void onResponse(Call<AdResponse> call, Response<AdResponse> response) {
                        carouselCallback.OnSuccessResult(response.body());
                    }

                    @Override
                    public void onFailure(Call<AdResponse> call, Throwable t) {
                        carouselCallback.OnFailureResult(t);
                    }
                });
    }

    public void getHomeJobList(final ResponseResultCallback<JobResponse, Throwable> joblistCallback, int page, int itemNum) {
        this.api.getJobLists(page, itemNum)
                .enqueue(new Callback<JobResponse>() {
                    @Override
                    public void onResponse(Call<JobResponse> call, Response<JobResponse> response) {
                        joblistCallback.OnSuccessResult(response.body());
                    }

                    @Override
                    public void onFailure(Call<JobResponse> call, Throwable t) {
                        joblistCallback.OnFailureResult(t);
                    }
                });
    }

    public interface JobResultCallback<A, B> {
        void OnSuccessResult(A first);

        void OnFailureResult(B second);
    }
}
