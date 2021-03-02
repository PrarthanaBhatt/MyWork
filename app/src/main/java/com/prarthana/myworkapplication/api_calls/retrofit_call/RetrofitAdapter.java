package com.prarthana.myworkapplication.api_calls.retrofit_call;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.prarthana.myworkapplication.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RetrofitAdapter  extends RecyclerView.Adapter<RetrofitAdapter.MyViewHolder>{
    private Context mContext;
    private List<Movie> movieList;



    public RetrofitAdapter(Context mContext, List<Movie> movieList) {
        this.mContext = mContext;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.movie_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(movieList.get(position).getId());
        holder.title.setText(movieList.get(position).getName());

        //Adding Glide library to display the images
        Glide.with(mContext)
                .load(movieList.get(position).getImage())
                .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView id;
        ImageView img;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView1);
            id = itemView.findViewById(R.id.textView2);
            img = itemView.findViewById(R.id.imageView);
        }
    }
}

