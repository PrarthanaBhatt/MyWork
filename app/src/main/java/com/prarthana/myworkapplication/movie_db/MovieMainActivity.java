package com.prarthana.myworkapplication.movie_db;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.prarthana.myworkapplication.R;
import com.prarthana.myworkapplication.api_calls.retrofit_call.Movie;
import com.prarthana.myworkapplication.api_calls.retrofit_call.RetrofitAdapter;
import com.prarthana.myworkapplication.movie_db.movie_adaptor.MovieAdaptor;
import com.prarthana.myworkapplication.movie_db.network.ApiCall;
import com.prarthana.myworkapplication.movie_db.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

public class MovieMainActivity extends AppCompatActivity {
//https://api.themoviedb.org/3/movie/popular?api_key=e1eb9d73afc601612fb492d7f0e060aa&language=en-US&page=1

    RecyclerView recyclerMovie;
    ArrayList<MovieModel> myMovieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_main);

        recyclerMovie = findViewById(R.id.recyclerMovie);

        ApiCall apiCall=RetrofitClient.getInstance().getApi();
        apiCall.movieModel("e1eb9d73afc601612fb492d7f0e060aa").enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                Toast.makeText(MovieMainActivity.this, response.body().getResults().get(0).getTitle().toString(), Toast.LENGTH_SHORT).show();
                recyclerMovie.setLayoutManager(new LinearLayoutManager(MovieMainActivity.this,recyclerMovie.VERTICAL,false));
                recyclerMovie.setAdapter(new MovieAdaptor(MovieMainActivity.this,new ArrayList<ResultsItem>(response.body().getResults())));

            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                Toast.makeText(MovieMainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}