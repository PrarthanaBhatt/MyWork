package com.prarthana.myworkapplication.api_calls.okhttp_call;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.os.Bundle;
import android.widget.TextView;

import com.prarthana.myworkapplication.MainActivity;
import com.prarthana.myworkapplication.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class OkHttpMainActivity extends AppCompatActivity {

    TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_main);

        textViewResult = findViewById(R.id.textViewResult);

        OkHttpClient client = new OkHttpClient();
        String url = "http://reqres.in/api/users?page=2";

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if(response.isSuccessful()){
                    String myResponse = response.body().string();

                    OkHttpMainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                           textViewResult.setText(myResponse);
                        }
                    });
                }
            }
        });
    }
}

