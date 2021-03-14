package com.prarthana.myworkapplication.movie_db;


import android.os.Bundle;
import android.widget.Toast;

import com.prarthana.myworkapplication.R;
import com.prarthana.myworkapplication.movie_db.movie_adaptor.MovieAdaptor;
import com.prarthana.myworkapplication.movie_db.network.ApiCall;
import com.prarthana.myworkapplication.movie_db.network.RetrofitClient;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieMainActivity extends AppCompatActivity {


    private ApiCall apiInterface;
    RecyclerView recyclerMovie;
    ArrayList<MovieModel> myMovieList;

    private ApiCall apiCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_main);

        recyclerMovie = findViewById(R.id.recyclerMovie);

        apiCall = RetrofitClient.getClient().create(ApiCall.class);

        apiCall.movieModel("e1eb9d73afc601612fb492d7f0e060aa").enqueue(new Callback<MovieModel>() {

            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                Toast.makeText(MovieMainActivity.this, response.body().getResults().get(0).getTitle().toString(), Toast.LENGTH_SHORT).show();
                recyclerMovie.setLayoutManager(new GridLayoutManager(MovieMainActivity.this,3,recyclerMovie.VERTICAL,false));
                recyclerMovie.setAdapter(new MovieAdaptor(MovieMainActivity.this,new ArrayList<ResultsItem>(response.body().getResults())));

            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                Toast.makeText(MovieMainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}