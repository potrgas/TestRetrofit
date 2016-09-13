package com.example.testretrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetroFactory {
    private static String baseUrl = "http://172.16.25.195:8082/MyWeb/";

    private static Retrofit jsonRetrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(JacksonConverterFactory.create())
            .client(genericClient())
            .build();

    private static Retrofit stringRetrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build();

    public static RetrofitService getJsonService() {
        RetrofitService service = jsonRetrofit.create(RetrofitService.class);
        return service;
    }

    public static RetrofitService getStringService() {
        RetrofitService service = stringRetrofit.create(RetrofitService.class);
        return service;
    }

    /**
     * 统一添加请求头
     * @return
     */
    public static OkHttpClient genericClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                                .addHeader("Accept-Encoding", "gzip, deflate")
                                .addHeader("Connection", "keep-alive")
                                .addHeader("Accept", "*/*")
                                .addHeader("Cookie", "\"add cookies here\"")
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();

        return httpClient;
    }
}
