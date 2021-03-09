package com.prarthana.myworkapplication.movie_db.network;

import com.prarthana.myworkapplication.movie_db.MovieDetailModel;
import com.prarthana.myworkapplication.movie_db.MovieModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCall {

    @GET("movie/popular")
    Call<MovieModel> movieModel(@Query("api_key") String strApiKey);

    @GET("movie")
    Call<MovieDetailModel> movieDetailModel(@Query("id" ) String id,
                                            @Query("api_key") String apikey);





}
