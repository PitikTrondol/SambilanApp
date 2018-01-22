package com.sambilan.sambilan.network;

import com.sambilan.sambilan.model.Employer;
import com.sambilan.sambilan.model.Jobs;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Afriandi Haryanto on 1/20/2018.
 */

public interface JobApi {

    @GET("/jobs")
    Call<Jobs> getAllJobs();

    @GET("/employer/{id}")
    Call<Employer> getEmployer(@Path("id") String id);
}
