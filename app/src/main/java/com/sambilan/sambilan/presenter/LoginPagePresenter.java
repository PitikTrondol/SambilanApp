package com.sambilan.sambilan.presenter;

import com.sambilan.sambilan.model.Login;
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
        this.api = NetworkService.createLoginPageAPI();
    }
    public void getAll(final LoginPagePresenter.LoginResultCallback<Login,Throwable> loginCallback){
        this.api.getData().enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                loginCallback.OnSuccessResult(response.body());
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                loginCallback.OnFailureResult(t);
            }
        });
    }
    public interface LoginResultCallback<A, B> {
        void OnSuccessResult(A first);

        void OnFailureResult(B second);
    }
}

