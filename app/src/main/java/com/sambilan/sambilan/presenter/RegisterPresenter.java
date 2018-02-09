package com.sambilan.sambilan.presenter;

import com.sambilan.sambilan.model.RegisterRequest;
import com.sambilan.sambilan.model.RegisterResponse;
import com.sambilan.sambilan.network.NetworkService;
import com.sambilan.sambilan.network.RegisterPageAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andhika Putranto on 2/7/2018.
 */

public class RegisterPresenter {
    RegisterPageAPI api;

    public RegisterPresenter(){
        this.api= NetworkService.createRegisterAPI();
    }
    public void postRegister(final RegisterPresenter.RegisterResultCallback<RegisterResponse,Throwable>registerCallBack , RegisterRequest register){
        this.api.postDataRegister(register).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                registerCallBack.OnSuccessResult(response.body());
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                registerCallBack.OnFailureResult(t);
            }
        });
    }



    public interface RegisterResultCallback<A, B> {
        void OnSuccessResult(A first);

        void OnFailureResult(B second);
    }

}
