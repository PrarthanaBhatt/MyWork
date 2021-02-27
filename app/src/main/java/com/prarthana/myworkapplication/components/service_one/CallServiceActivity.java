package com.prarthana.myworkapplication.components.service_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.prarthana.myworkapplication.R;

public class CallServiceActivity extends AppCompatActivity {
    String msg = "Android : ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_service);
    }

    public void startService(View view) {
        startService(new Intent(getBaseContext(), MyService2.class));
    }

    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), MyService2.class));
    }
}