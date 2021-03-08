package com.prarthana.myworkapplication.data_binding_recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.prarthana.myworkapplication.R;
import com.prarthana.myworkapplication.databinding.DatabindingRecyclerViewItemBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Book> list;

    public RecyclerViewAdapter(List<Book> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        DatabindingRecyclerViewItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.databinding_recycler_view_item,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.textTitle.setText(list.get(position).getTitle());
        holder.binding.textAuthor.setText(list.get(position).getAuthor());
//        holder.binding.imgBookCover.setImageDrawable(list.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

      private DatabindingRecyclerViewItemBinding binding;
      public ViewHolder(@NonNull DatabindingRecyclerViewItemBinding binding) {
          super(binding.getRoot());
      }
  }
}
