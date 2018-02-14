package com.sambilan.sambilan.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Afriandi Haryanto on 1/20/2018.
 */

public class NetworkService {

    private static Retrofit retrofitInstance;
    private static final String BASE_URL = "http://sambilan.herokuapp.com";

    /**
     * ===================================
     * Create singleton of reftrofit instance
     * ===================================
     * starts with                  Retrofit.Builder
     * add base url                 .baseUrl()
     * converter (Gson kalo disini) .addConverterFactory()
     * add client                   .client()
     * eksekusi dengan build        .build()
     */
    private static Retrofit getRetrofit() {

        if (null == retrofitInstance) {
            retrofitInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client())
                    .build();
        }

        return retrofitInstance;
    }

    public static LandingPageApi createLandingPageApi() {
        return getRetrofit().create(LandingPageApi.class);
    }

    public static InvitationPageAPI crateInvitationAPI() {
        return getRetrofit().create(InvitationPageAPI.class);
    }
    public static DetailJobsApi createJobsApi(){
        return getRetrofit().create(DetailJobsApi.class);
    }

    public static EmployeeFlowAPI createEmployeeFlowApi(){
        return getRetrofit().create(EmployeeFlowAPI.class);
    }

    public static RegisterPageAPI createRegisterAPI(){
        return getRetrofit().create(RegisterPageAPI.class);
    }

    public static AddJobApi createAddJobApi(){
        return getRetrofit().create(AddJobApi.class);
    }

    public static LoginPageAPI createLoginAPI(){
        return getRetrofit().create(LoginPageAPI.class);
    }

    /**
     * ===================================
     * Create OkHttpClient instance
     * ===================================
     * start with               OkHttpClient.Builder()
     * determine timeout        .readTimeout().connectTimeout().writeTimeout()
     * add interceptor          .addInterceptor()
     * execute with             .build()
     */
    private static OkHttpClient client() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }
}
