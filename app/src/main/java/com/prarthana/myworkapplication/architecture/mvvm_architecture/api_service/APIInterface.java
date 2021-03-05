package com.prarthana.myworkapplication.architecture.mvvm_architecture.api_service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("v1/quotes")
    Call<List<Response>> getMessage();
}
