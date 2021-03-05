package com.prarthana.myworkapplication.api_calls.volley_call;

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

public class VolleyAdapter extends RecyclerView.Adapter<VolleyAdapter.MyViewHolder>{
private Context mContext;
private List<ModelVolley> modelVolleyList;



public VolleyAdapter(Context mContext, List<ModelVolley> movieList) {
        this.mContext = mContext;
        this.modelVolleyList = movieList;
        }

@NonNull
@Override
public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.single_row_design_volley,parent,false);
        return new MyViewHolder(v);
        }

@Override
public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textTitle.setText(modelVolleyList.get(position).getName());

        //Adding Glide library to display the images
        Glide.with(mContext)
        .load(modelVolleyList.get(position).getImage())
        .into(holder.imageView);

        }

@Override
public int getItemCount() {
        return modelVolleyList.size();
        }

public static class MyViewHolder extends RecyclerView.ViewHolder{
    TextView textTitle;
    ImageView imageView;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        textTitle = itemView.findViewById(R.id.textTitle);
        imageView = itemView.findViewById(R.id.imageView);
    }
}
}

