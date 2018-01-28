package com.sambilan.sambilan.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Afriandi Haryanto on 1/20/2018.
 */

public class NetworkService {

    private static final String BASE_URL = "http://private-a2125f-afriandi.apiary-mock.com";
    private static Retrofit retrofitInstance;


    /**
     * ===================================
     * Create singleton of reftrofit instance
     * ===================================
     * createLandingPageApi instance Retrofit.Builder
     * add base url
     * converter (Gson kalo disini)
     * add client
     * eksekusi dengan build
     */

    public static Retrofit getRetrofit() {

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

    public static EmployerApi createEmpApi() {
        return getRetrofit().create(EmployerApi.class);
    }

    public static OkHttpClient client() {

        /**
         * createLandingPageApi instance OkHttpClient.Builder
         * determine timeout (read, connect, write)
         * add interceptor
         * execute with build
         */

//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
//                .setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
//                .addInterceptor(interceptor)
                .build();
    }
}
