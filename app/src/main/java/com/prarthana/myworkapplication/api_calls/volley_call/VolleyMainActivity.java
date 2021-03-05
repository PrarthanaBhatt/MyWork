package com.prarthana.myworkapplication.api_calls.volley_call;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.prarthana.myworkapplication.R;

import org.json.JSONException;

public class VolleyMainActivity extends AppCompatActivity {

    String url = "https://jsonplaceholder.typicode.com/todos/1";
    Button btn_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_main);

        btn_start = findViewById(R.id.btn_start);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    getData();
            }
        });
    }

//    private void getData() {
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//
//        //request and response format should be same
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<>() {
//            @Override
//            public void onResponse(Object response) {
//                    try{
//                        Toast.makeText(VolleyMainActivity.this,
//                                "userId:" + response.getInt("userId") + "\n" +
//                                "Id:" + response.getInt("id") + "\n" +
//                                "title:" + response.toString("title") + "\n"+
//                                "completed:"+ response.getBoolean("completed"),
//                                Toast.LENGTH_SHORT).show();
//
//                    }catch (JSONException e){
//                        e.printStackTrace();
//                    }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(VolleyMainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        requestQueue.add(jsonObjectRequest);
//    }
}