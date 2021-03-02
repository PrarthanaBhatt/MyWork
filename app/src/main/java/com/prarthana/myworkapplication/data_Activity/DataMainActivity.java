package com.prarthana.myworkapplication.data_Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.prarthana.myworkapplication.R;
import com.prarthana.myworkapplication.databinding.ActivityDataMainBinding;

public class DataMainActivity extends AppCompatActivity {

    ActivityDataMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_data_main);
        binding.setUser(new User("Prarthana","Bhatt"));
    }
}