package com.sambilan.sambilan.presenter;

import android.util.Log;

import com.sambilan.sambilan.SambilanApplication;
import com.sambilan.sambilan.model.Employee;
import com.sambilan.sambilan.model.response.AdResponse;
import com.sambilan.sambilan.model.response.JobResponse;
import com.sambilan.sambilan.model.response.PostResponse;
import com.sambilan.sambilan.network.NetworkService;
import com.sambilan.sambilan.network.LandingPageApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Afriandi Haryanto on 1/21/2018.
 */

public class LandingPagePresenter {

    LandingPageApi api;

    public LandingPagePresenter() {
        this.api = NetworkService.createLandingPageApi();
    }

    public void getHomeCarousel(final ResponseResultCallback<AdResponse, Throwable> carouselCallback) {
        this.api.getCarousel()
                .enqueue(new Callback<AdResponse>() {
                    @Override
                    public void onResponse(Call<AdResponse> call, Response<AdResponse> response) {
                        carouselCallback.OnSuccessResult(response.body());
                    }

                    @Override
                    public void onFailure(Call<AdResponse> call, Throwable t) {
                        carouselCallback.OnFailureResult(t);
                    }
                });
    }

    public void getHomeJobList(final ResponseResultCallback<JobResponse, Throwable> joblistCallback,
                               String token, final int page, final int itemNum) {
        this.api.getJobLists(token, page, itemNum)
                .enqueue(new Callback<JobResponse>() {
                    @Override
                    public void onResponse(Call<JobResponse> call, Response<JobResponse> response) {
                        joblistCallback.OnSuccessResult(response.body());
                    }

                    @Override
                    public void onFailure(Call<JobResponse> call, Throwable t) {
                        joblistCallback.OnFailureResult(t);
                    }
                });
    }

    public final void getGuestJoblist (final ResponseResultCallback<JobResponse, Throwable> joblistCallback,
                                       int page, int itemNum) {

        this.api.getGuestJoblist(page, itemNum)
                .enqueue(new Callback<JobResponse>() {
                    @Override
                    public void onResponse(Call<JobResponse> call, Response<JobResponse> response) {
                        joblistCallback.OnSuccessResult(response.body());
                    }

                    @Override
                    public void onFailure(Call<JobResponse> call, Throwable t) {
                        joblistCallback.OnFailureResult(t);
                    }
                });
    }

    public void getEmployees(final ResponseResultCallback<List<Employee>, Throwable> employeeCallback,
                             String token, int page, int itemNum) {
        this.api.getEmployee(token, page, itemNum)
                .enqueue(new Callback<PostResponse<String, List<Employee>>>() {
                    @Override
                    public void onResponse(Call<PostResponse<String, List<Employee>>> call, Response<PostResponse<String, List<Employee>>> response) {
                        employeeCallback.OnSuccessResult(response.body().getData());
                    }

                    @Override
                    public void onFailure(Call<PostResponse<String, List<Employee>>> call, Throwable t) {
                        employeeCallback.OnFailureResult(t);
                    }
                });
    }
}
