package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.WaitingPageResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by febrian on 01/02/18.
 */

public interface WaitingPageApi {

    @GET("/waitingpage")
    Call<WaitingPageResponse> getResources();
}
