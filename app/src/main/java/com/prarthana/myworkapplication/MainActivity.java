package com.prarthana.myworkapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.prarthana.myworkapplication.activity_lifecycle.LifecycleMainActivity;
import com.prarthana.myworkapplication.components.ComponentsMainActivity;
import com.prarthana.myworkapplication.data_persistence.DataPersistenceMainActivity;
import com.prarthana.myworkapplication.layout.LayoutMainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    public void callOne(View view) {
        Intent intent = new Intent(MainActivity.this, LayoutMainActivity.class);
        startActivity(intent);
    }

    public void callTwo(View view) {
        Intent intent = new Intent(MainActivity.this, ComponentsMainActivity.class);
        startActivity(intent);
    }

    public void callThree(View view) {
        Intent intent = new Intent(MainActivity.this, LifecycleMainActivity.class);
        startActivity(intent);
    }

    public void callFour(View view) {
        Intent intent = new Intent(MainActivity.this, DataPersistenceMainActivity.class);
        startActivity(intent);
    }
}