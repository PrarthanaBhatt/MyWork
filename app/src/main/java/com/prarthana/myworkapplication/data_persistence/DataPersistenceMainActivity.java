package com.prarthana.myworkapplication.data_persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.prarthana.myworkapplication.R;
import com.prarthana.myworkapplication.data_persistence.shared_pref.SharedPrefActivity;
import com.prarthana.myworkapplication.data_persistence.sql_data.SqlMainActivity;

public class DataPersistenceMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_persistence_main);
    }

    public void callSharedPref(View view) {
        Intent intent = new Intent(DataPersistenceMainActivity.this, SharedPrefActivity.class);
        startActivity(intent);
    }

    public void callSQLite(View view) {
        Intent intent = new Intent(DataPersistenceMainActivity.this, SqlMainActivity.class);
        startActivity(intent);
    }

    public void callInternal(View view) {
        Toast.makeText(this, "Internal", Toast.LENGTH_SHORT).show();
    }
}