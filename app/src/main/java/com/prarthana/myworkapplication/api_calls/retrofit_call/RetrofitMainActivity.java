package com.prarthana.myworkapplication.api_calls.retrofit_call;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.Toast;

import com.prarthana.myworkapplication.R;

import java.util.ArrayList;
import java.util.List;

public class RetrofitMainActivity extends AppCompatActivity {

    //    TextView txt;
    RecyclerView recyclerView;
    List<Movie> movieList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_main);

        recyclerView = findViewById(R.id.recyclerView);
        movieList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieApi movieApi = retrofit.create(MovieApi.class);

        Call<List<Movie>> call  = movieApi.getMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(response.code() != 200){
                    //handle the error and display it
                    return;
                }
                List<Movie> movies = response.body();

                for (Movie movie : movies){
                    movieList.add(movie);
                }
                PutDataIntoRecyclerView(movieList);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Toast.makeText(RetrofitMainActivity.this, "Something went wrong..try sometime later", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void PutDataIntoRecyclerView(List<Movie> movieList) {
        RetrofitAdapter adaptery = new RetrofitAdapter(this,movieList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptery);
    }


}