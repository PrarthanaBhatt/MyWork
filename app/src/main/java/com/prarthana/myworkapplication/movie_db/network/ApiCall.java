package com.prarthana.myworkapplication.movie_db.network;

import com.prarthana.myworkapplication.movie_db.MovieModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCall {

    @GET("popular")
    Call<MovieModel> movieModel(@Query("api_key") String strApiKey);



}
