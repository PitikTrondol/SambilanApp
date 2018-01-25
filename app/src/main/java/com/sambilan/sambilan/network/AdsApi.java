package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.Ads;
import com.sambilan.sambilan.model.Employers;
import com.sambilan.sambilan.model.Jobs;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Afriandi Haryanto on 1/20/2018.
 */

public interface AdsApi {

    @GET("/ads")
    Call<Ads> getAllAds();
}