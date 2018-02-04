package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.Login;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by Andhika Putranto on 2/4/2018.
 */

public interface LoginPageAPI {
    @POST("/api/v1/users/sign_in")
    Call<Login> getData();

}
