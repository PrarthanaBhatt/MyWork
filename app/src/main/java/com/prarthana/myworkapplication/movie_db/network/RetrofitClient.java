package com.prarthana.myworkapplication.movie_db.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static RetrofitClient retrofitClient;
    public static Retrofit retrofit;



    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if(retrofitClient == null){
            retrofitClient = new RetrofitClient();

        }
        return retrofitClient;
    }



    public ApiCall getApi(){
        return retrofit.create(ApiCall.class);
    }

}
