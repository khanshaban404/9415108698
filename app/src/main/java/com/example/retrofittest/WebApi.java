package com.example.retrofittest;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.HeaderMap;
import retrofit2.http.GET;

public interface WebApi {
    @GET("/public/v1/users")
    Call<DemoDataModel> getDemoData(@HeaderMap Map<String, String> header);
}
