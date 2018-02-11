package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.RegisterRequest;
import com.sambilan.sambilan.model.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Andhika Putranto on 2/7/2018.
 */

public interface RegisterPageAPI {
    @POST("/api/v1/users/sign_up")
    Call<RegisterResponse>postDataRegister(@Body RegisterRequest register);
}
