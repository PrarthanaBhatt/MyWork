package com.prarthana.myworkapplication.room_orm;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.prarthana.myworkapplication.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<MainData> dataList;
    private Activity context;
    private RoomDB database;

    public MainAdapter(Activity context,List<MainData> dataList){
        this.context = context;
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_main,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainData data = dataList.get(position);
        database = RoomDB.getInstance(context);
        holder.textView.setText(data.getText());
        holder.btEdit.setOnClickListener(v -> {
            //Initialize main data
            MainData d = dataList.get(holder.getAdapterPosition());
            int sID = d.getID();
            String sText = d.getText();

            Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.dialog_update);

            int width = WindowManager.LayoutParams.MATCH_PARENT;
            int height = WindowManager.LayoutParams.WRAP_CONTENT;

            dialog.getWindow().setLayout(width,height);
            dialog.show();

            EditText editText = dialog.findViewById(R.id.edit_text);
            Button btUpdate = dialog.findViewById(R.id.bt_update);

            editText.setText(sText);

            btUpdate.setOnClickListener(v1 -> {
                dialog.dismiss();
                String uText = editText.getText().toString().trim();
                database.mainDao().update(sID,uText);
                dataList.clear();
                dataList.addAll(database.mainDao().getAll());
                notifyDataSetChanged();
            });


        });

        holder.btDelete.setOnClickListener(v -> {
            //Initialize main data
            MainData d = dataList.get(holder.getAdapterPosition());
            //Delete text from database
            database.mainDao().delete(d);
            //Notify when data is deleted
            int position1 = holder.getAdapterPosition();
            dataList.remove(position1);
            notifyItemRemoved(position1);
            notifyItemRangeChanged(position1,dataList.size());

        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView btEdit,btDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
            btEdit = itemView.findViewById(R.id.bt_edit);
            btDelete = itemView.findViewById(R.id.bt_delete);

        }
    }
}
