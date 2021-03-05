package com.prarthana.myworkapplication.api_calls.HttpUrlConnection_call;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.prarthana.myworkapplication.R;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlConnectionMainActivity extends AppCompatActivity {



    public class BackgroundTask extends AsyncTask<String, Void,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("Background","onPreExecute: ran");
        }

        @Override
        protected String doInBackground(String... strings) {
            Log.d("Background","doInBackground: ran");
            String result = "";
            URL url;
            HttpURLConnection connection;
            try{
             url = new URL("https://api.androidhive.info/contacts/");
                connection = (HttpURLConnection) url.openConnection();
                InputStream in = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while(data != -1){
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }
            }catch (Exception e){
                e.printStackTrace();
                return "Something went wrong";
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("Background","onPostExecute: ran");
            Log.d("Background",s);
            Toast.makeText(HttpUrlConnectionMainActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_url_connection_main);
        BackgroundTask myTask = new BackgroundTask();
        myTask.execute();
    }

    public void callToast(View view) {
        Toast.makeText(this, "Have a good day..", Toast.LENGTH_SHORT).show();
    }
}