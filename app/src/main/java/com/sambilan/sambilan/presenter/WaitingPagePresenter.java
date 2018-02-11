package com.sambilan.sambilan.presenter;

import com.sambilan.sambilan.model.response.WaitingPageResponse;
import com.sambilan.sambilan.network.NetworkService;
import com.sambilan.sambilan.network.WaitingPageApi;

import javax.xml.transform.sax.TemplatesHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by febrian on 01/02/18.
 */

public class WaitingPagePresenter {

    WaitingPageApi api;

    public WaitingPagePresenter() {
        this.api = NetworkService.createWaitingPageApi();
    }

    public void getAllWaitingList(final ResponseResultCallback<WaitingPageResponse, Throwable> waitingListCallback) {

        this.api.getWaitingList().enqueue(new Callback<WaitingPageResponse>() {
            @Override
            public void onResponse(Call<WaitingPageResponse> call, Response<WaitingPageResponse> response) {
                waitingListCallback.OnSuccessResult(response.body());
            }

            @Override
            public void onFailure(Call<WaitingPageResponse> call, Throwable t) {
                waitingListCallback.OnFailureResult(t);
            }
        });
    }

    public void postCancelWaitingJob(final ResponseResultCallback<String, Throwable> cancelCallback,
                                     int id,
                                     int jobId,
                                     String message) {

//        this.api.postWaitingAction(id, jobId, message).enqueue(new Callback<WaitingPageResponse.Post>() {
//            @Override
//            public void onResponse(Call<WaitingPageResponse.Post> call, Response<WaitingPageResponse.Post> response) {
//                cancelCallback.OnSuccessResult(response.body().getStatus());
//            }
//
//            @Override
//            public void onFailure(Call<WaitingPageResponse.Post> call, Throwable t) {
//                cancelCallback.OnFailureResult(t);
//            }
//        });
    }
}
