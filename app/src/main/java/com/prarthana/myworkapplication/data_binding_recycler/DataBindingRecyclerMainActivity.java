package com.prarthana.myworkapplication.data_binding_recycler;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Build;
import android.os.Bundle;

import com.prarthana.myworkapplication.R;
import com.prarthana.myworkapplication.databinding.ActivityDataBindingRecyclerMainBinding;

import java.util.ArrayList;

public class DataBindingRecyclerMainActivity extends AppCompatActivity {

    private ActivityDataBindingRecyclerMainBinding binding;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding_recycler_main);
        ArrayList<Book> bookList = new ArrayList<>();



            bookList.add(new Book("The State of Grace", "Lois Lewandowski", getDrawable(R.drawable.book_1)));
            bookList.add(new Book("Murder At The Rocks", "Jill Paterson", getDrawable(R.drawable.book_2)));
            bookList.add(new Book("Sleepless Part one", "Marc Layton", getDrawable(R.drawable.book_3)));
            bookList.add(new Book("Devil on Deck", "Madison Kent", getDrawable(R.drawable.book_4)));
            bookList.add(new Book("Dark Promise", "Julia Crane & Talia Jager", getDrawable(R.drawable.book_5)));
            bookList.add(new Book("The Dawnvel Druids", "William Collins", getDrawable(R.drawable.book_6)));
            bookList.add(new Book("The Frights of Fiji", "Sanayna Prasad", getDrawable(R.drawable.book_7)));
            bookList.add(new Book("Skyborn Ignite", "Hannah Parker", getDrawable(R.drawable.book_8)));



        RecyclerViewAdapter adapter = new RecyclerViewAdapter(bookList);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        binding.recyclerView.setAdapter(adapter);

    }
}