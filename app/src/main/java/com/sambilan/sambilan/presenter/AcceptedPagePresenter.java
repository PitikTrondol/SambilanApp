package com.sambilan.sambilan.presenter;

import com.sambilan.sambilan.model.response.AcceptedResponse;
import com.sambilan.sambilan.network.DiterimaPageAPI;
import com.sambilan.sambilan.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Afriandi Haryanto on 2/9/2018.
 */

public class AcceptedPagePresenter {

    private DiterimaPageAPI api;

    public AcceptedPagePresenter() {
        this.api = NetworkService.createAcceptedPageApi();
    }

    public void getAcceptedJobs(final ResponseResultCallback<AcceptedResponse, Throwable> acceptedCallback,
                                int userID) {

        this.api.getAcceptedJobs(userID)
                .enqueue(new Callback<AcceptedResponse>() {
                    @Override
                    public void onResponse(Call<AcceptedResponse> call, Response<AcceptedResponse> response) {
                        acceptedCallback.OnSuccessResult(response.body());
                    }

                    @Override
                    public void onFailure(Call<AcceptedResponse> call, Throwable t) {
                        acceptedCallback.OnFailureResult(t);
                    }
                });
    }

}
