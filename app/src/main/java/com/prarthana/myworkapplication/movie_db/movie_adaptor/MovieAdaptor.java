package com.prarthana.myworkapplication.movie_db.movie_adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.prarthana.myworkapplication.R;
import com.prarthana.myworkapplication.movie_db.MovieModel;
import com.prarthana.myworkapplication.movie_db.ResultsItem;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdaptor extends RecyclerView.Adapter<MovieAdaptor.MyViewHolder>{
    private Context mContext;
    private ArrayList<ResultsItem> myMovieList;

    public MovieAdaptor(Context mContext, ArrayList<ResultsItem> myMovieList) {
        this.mContext = mContext;
        this.myMovieList = myMovieList;
    }

    @NonNull
    @Override
    public MovieAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.single_row_movie_list,parent,false);
        return new MovieAdaptor.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdaptor.MyViewHolder holder, int position) {

        final ResultsItem movieModel = myMovieList.get(position);

        holder.movieTitle.setText(myMovieList.get(position).getTitle());


        //Adding Glide library to display the images
        Glide.with(mContext)
                .load("https://image.tmdb.org/t/p/w342"+myMovieList.get(position).getPosterPath())
                .into(holder.imgMovie);


    }

    @Override
    public int getItemCount() {
        return myMovieList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView movieTitle;
        ImageView imgMovie;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.movieTitle);
            imgMovie = itemView.findViewById(R.id.imgMovie);
        }
    }
}
