package com.prarthana.myworkapplication.architecture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SearchIterator;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.prarthana.myworkapplication.R;

import com.prarthana.myworkapplication.architecture.mvp_architecture.MvpMainActivity;
import com.prarthana.myworkapplication.architecture.mvvm_architecture.MvvmMainActivity;

public class ArchitectureMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arcitecture_main);
    }


    public void callMVP(View view) {
        Intent intent = new Intent(ArchitectureMainActivity.this, MvpMainActivity.class);
        startActivity(intent);
    }

    public void callMVVM(View view) {
        Toast.makeText(this, "MVVM", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(ArchitectureMainActivity.this, MvvmMainActivity.class);
//        startActivity(intent);
    }
}