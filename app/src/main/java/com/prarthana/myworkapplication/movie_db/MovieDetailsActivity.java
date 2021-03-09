package com.prarthana.myworkapplication.movie_db;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.prarthana.myworkapplication.R;
import com.prarthana.myworkapplication.movie_db.movie_adaptor.MovieAdaptor;
import com.prarthana.myworkapplication.movie_db.network.ApiCall;
import com.prarthana.myworkapplication.movie_db.network.RetrofitClient;

import java.util.ArrayList;

public class MovieDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);


        int id = getIntent().getIntExtra("MOVIE_ID", 0);
        Toast.makeText(this, "Get Movie Id"+id, Toast.LENGTH_SHORT).show();


//        ApiCall apiCall= RetrofitClient.getInstance().getApi();
//        apiCall.movieDetailModel("id","e1eb9d73afc601612fb492d7f0e060aa").enqueue(new Callback<MovieDetailModel>(){
//
//            @Override
//            public void onResponse(Call<MovieDetailModel> call, Response<MovieDetailModel> response) {
//                Toast.makeText(MovieDetailsActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<MovieDetailModel> call, Throwable t) {
//                Toast.makeText(MovieDetailsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }
}