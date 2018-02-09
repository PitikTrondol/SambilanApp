package com.sambilan.sambilan.presenter;

import com.sambilan.sambilan.model.Login;
import com.sambilan.sambilan.model.LoginRequest;
import com.sambilan.sambilan.model.LoginResponse;
import com.sambilan.sambilan.network.LoginPageAPI;
import com.sambilan.sambilan.network.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Andhika Putranto on 2/4/2018.
 */

public class LoginPagePresenter {
    LoginPageAPI api;

    public LoginPagePresenter() {
        this.api = NetworkService.createLoginAPI();
    }
    public void postAll(final LoginPagePresenter.LoginResultCallback<LoginResponse,Throwable> loginCallback, LoginRequest request){
        this.api.postData(request).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                loginCallback.OnSuccessResult(response.body());

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loginCallback.OnFailureResult(t);

            }

//            @Override
//            public void onResponse(Call<Login> call, Response<Login> response) {
//                loginCallback.OnSuccessResult(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<Login> call, Throwable t) {
//                loginCallback.OnFailureResult(t);
//            }
        });
    }
    public interface LoginResultCallback<A, B> {
        void OnSuccessResult(A first);

        void OnFailureResult(B second);
    }
}

