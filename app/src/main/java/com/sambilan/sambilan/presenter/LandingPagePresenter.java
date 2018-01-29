package com.sambilan.sambilan.presenter;

import com.sambilan.sambilan.model.LandingPageResponse;
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

    public void getJobList(final JobResultCallback<LandingPageResponse, Throwable> jobResultCallbackcallback) {
        this.api.getResources().enqueue(new Callback<LandingPageResponse>() {
            @Override
            public void onResponse(Call<LandingPageResponse> call, Response<LandingPageResponse> response) {
                jobResultCallbackcallback.OnSuccessResult(response.body());
            }

            @Override
            public void onFailure(Call<LandingPageResponse> call, Throwable t) {
                jobResultCallbackcallback.OnFailureResult(t);
            }
        });
    }

    public interface JobResultCallback<A, B> {
        void OnSuccessResult(A first);

        void OnFailureResult(B second);
    }
}
