package com.example.rumi.realstate.network;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitBuilder {

    //    private static final String BASE_URL = "http://localhost:8000/api/";
    private static final String BASE_URL = "http://192.168.0.104:8000/api/";

    private static OkHttpClient client = buildClient();
    private static Retrofit retrofit = buildRetrofit();

    private static OkHttpClient buildClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request request = chain.request();

                    Request.Builder builder1 = request.newBuilder()
                            .addHeader("Accept", "application/json")
                            .addHeader("X-Requested-With", "XMLHttpRequest")
                            .addHeader("Content-Type", "application/x-www-form-urlencoded")
                            .addHeader("Connection", "close");

                    request = builder1.build();

                    return chain.proceed(request);
                });

//        if (BuildConfig.DEBUG) {
//            builder.addNetworkInterceptor(new StethoInterceptor());
//        }

        return builder.build();
    }


    public static Retrofit buildRetrofit() {
        if (retrofit == null) {
            synchronized (RetrofitBuilder.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .client(client)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }

        return retrofit;
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }
}
