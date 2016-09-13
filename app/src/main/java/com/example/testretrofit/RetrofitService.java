package com.example.testretrofit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface RetrofitService {
    @GET("getMethod")
    Call<String> getTest();

    @FormUrlEncoded
    @POST("createUser")
    Call<Void> createPerson(@Field("name") String name, @Field("age") String age);

    @FormUrlEncoded
    @POST("getcarousel")
    Call<Person> getUsers(@FieldMap Map<String, String> map);

    @GET("getjson")
    Call<String> getJson(@QueryMap Map<String,String> map);
}
