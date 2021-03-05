package com.prarthana.myworkapplication.api_calls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.prarthana.myworkapplication.R;
import com.prarthana.myworkapplication.api_calls.HttpUrlConnection_call.HttpUrlConnectionMainActivity;
import com.prarthana.myworkapplication.api_calls.okhttp_call.OkHttpMainActivity;
import com.prarthana.myworkapplication.api_calls.retrofit_call.RetrofitMainActivity;
import com.prarthana.myworkapplication.api_calls.volley_call.VolleyMainActivity;

public class ApiCallMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_call_main);
    }

    public void callRetrofit(View view) {
//        Toast.makeText(this, "retrofit call..", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ApiCallMainActivity.this, RetrofitMainActivity.class);
        startActivity(intent);
    }

    public void callVolley(View view) {
        Intent intent = new Intent(ApiCallMainActivity.this, VolleyMainActivity.class);
        startActivity(intent);
    }

    public void callOkHttp(View view) {
        Intent intent = new Intent(ApiCallMainActivity.this, OkHttpMainActivity.class);
        startActivity(intent);
    }

    public void callHttpUrl(View view) {
        Toast.makeText(this, "Get AsyncTask and in doBackground method call api with help of HttpUrlConnection..", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ApiCallMainActivity.this, HttpUrlConnectionMainActivity.class);
        startActivity(intent);
    }
}