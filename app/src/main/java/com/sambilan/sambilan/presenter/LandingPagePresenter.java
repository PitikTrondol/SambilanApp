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

    public void getAllResources(final JobResultCallback<LandingPageResponse, Throwable> resourceCallback,
                                int page, int limit) {
        this.api.getResources(page, limit).enqueue(new Callback<LandingPageResponse>() {
            @Override
            public void onResponse(Call<LandingPageResponse> call, Response<LandingPageResponse> response) {
                resourceCallback.OnSuccessResult(response.body());
            }

            @Override
            public void onFailure(Call<LandingPageResponse> call, Throwable t) {
                resourceCallback.OnFailureResult(t);
            }
        });
    }

    public interface JobResultCallback<A, B> {
        void OnSuccessResult(A first);
        void OnFailureResult(B second);
    }
}
