package com.example.retrofittest;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequest {


    private static final String BASE_URL = "https://gorest.co.in";

    /**
     * Create an instance of Retrofit object
     * */

    public  static Retrofit getClient(){
        Retrofit retrofit = null;


        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
