package com.prarthana.myworkapplication.api_calls.volley_call;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.prarthana.myworkapplication.R;
import com.prarthana.myworkapplication.api_calls.retrofit_call.RetrofitAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class VolleyMainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ModelVolley> dataArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_main);

        recyclerView = findViewById(R.id.list);


        String url = "https://picsum.photos/v2/list";

        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Please wait...");
        dialog.setCancelable(true);
        dialog.show();

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                    if(response != null){
                        dialog.dismiss();
                        // change by using gson

                        Gson gson = new Gson();
                        ArrayList<ModelVolley> modelVolley = gson.fromJson(response,  new TypeToken<ArrayList<ModelVolley>>(){}.getType());
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
                        VolleyAdapter volleyAdapter = new VolleyAdapter(VolleyMainActivity.this,modelVolley);

                        recyclerView.setAdapter(volleyAdapter);

//
//                        try {
//                            JSONArray jsonArray =  new JSONArray(response);
//                            parseArray(jsonArray);
//
//                        }catch (JSONException e){
//                            e.printStackTrace();
//                        }
                    }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VolleyMainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);

    }

    private void parseArray(JSONArray jsonArray) {
        for(int i=0;i<jsonArray.length();i++){
            try{
                JSONObject object = jsonArray.getJSONObject(i);
                ModelVolley data = new ModelVolley();
                data.setName(object.getString("author"));
                data.setImage(object.getString("download_url"));
                dataArrayList.add(data);
                PutDataIntoRecyclerView(dataArrayList);

            }catch (JSONException e){
                e.printStackTrace();
            }
        }
    }

    private void PutDataIntoRecyclerView(ArrayList<ModelVolley> dataArrayList) {
        VolleyAdapter adaptery = new VolleyAdapter(this,dataArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptery);
    }


}
