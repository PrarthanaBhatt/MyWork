package com.prarthana.myworkapplication.api_calls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.prarthana.myworkapplication.R;

public class ApiCallMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_call_main);
    }

    public void callRetrofit(View view) {
        Toast.makeText(this, "retrofit call..", Toast.LENGTH_SHORT).show();
    }
}