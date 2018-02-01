package com.sambilan.sambilan.presenter;

import com.sambilan.sambilan.model.WaitingPageResponse;
import com.sambilan.sambilan.network.NetworkService;
import com.sambilan.sambilan.network.WaitingPageApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by febrian on 01/02/18.
 */

public class WaitingPagePresenter {

    WaitingPageApi api;

    public WaitingPagePresenter(){
        this.api = NetworkService.createWaitingPageApi();
    }

    public void getAllResources(final JobResultCallback<WaitingPageResponse, Throwable> resourcesCallback){
        this.api.getResources().enqueue(new Callback<WaitingPageResponse>() {
            @Override
            public void onResponse(Call<WaitingPageResponse> call, Response<WaitingPageResponse> response) {
                resourcesCallback.OnSuccessResult(response.body());
            }

            @Override
            public void onFailure(Call<WaitingPageResponse> call, Throwable t) {
                resourcesCallback.OnFailureResult(t);
            }
        });
    }

    public interface JobResultCallback<A, B>{
        void OnSuccessResult(A first);
        void OnFailureResult(B second);
    }
}
