package com.prarthana.myworkapplication.data_persistence.sql_data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.prarthana.myworkapplication.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>
{
    ArrayList<model> dataholder;

    public myadapter(ArrayList<model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {
        holder.dname.setText(dataholder.get(position).getName());
        holder.dcontact.setText(dataholder.get(position).getContact());
        holder.demail.setText(dataholder.get(position).getEmail());
        holder.displayAddress.setText(dataholder.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView dname,dcontact,demail,displayAddress;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            dname=(TextView)itemView.findViewById(R.id.displayname);
            dcontact=(TextView)itemView.findViewById(R.id.displaycontact);
            demail=(TextView)itemView.findViewById(R.id.displayemail);
            displayAddress=(TextView)itemView.findViewById(R.id.displayAddress);
        }
    }

}


