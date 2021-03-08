package com.prarthana.myworkapplication.room_orm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.prarthana.myworkapplication.R;

import java.util.ArrayList;
import java.util.List;

public class RoomOrmMainActivity extends AppCompatActivity {

    EditText editText;
    Button btAdd,btReset;
    RecyclerView recyclerView;

    List<MainData> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    RoomDB database;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_orm_main);

        editText = findViewById(R.id.edit_text);
        btAdd = findViewById(R.id.bt_add);
        btReset = findViewById(R.id.bt_reset);
        recyclerView = findViewById(R.id.recycler_view);

//        database = RoomDB.getInstance(this);
//        dataList = database.mainDAO().getAll();
//
//        linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//        adapter = new MainAdapter(RoomOrmMainActivity.this,dataList);
//        recyclerView.setAdapter(adapter);
//
//        add.setOnClickListener(v -> {
//            String sText = editText.getText().toString().trim();
//            if(!sText.equals("")){
//                MainData data = new MainData();
//                data.setText(sText);
//                database.mainDAO().insert(data);
//                editText.setText("");
//                dataList.addAll(database.mainDAO().getAll());
//                adapter.notifyDataSetChanged();
//            }
//        });
//
//        btnReset.setOnClickListener(v -> {
//                database.mainDAO().reset(dataList);
//                dataList.clear();
//                dataList.addAll(database.mainDAO().getAll());
//                adapter.notifyDataSetChanged();
//        });
    }
}