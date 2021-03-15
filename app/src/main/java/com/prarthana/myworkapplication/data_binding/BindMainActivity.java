package com.prarthana.myworkapplication.data_binding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.prarthana.myworkapplication.R;
import com.prarthana.myworkapplication.databinding.ActivityBindMainBinding;
import com.prarthana.myworkapplication.databinding.ActivityDataBindingRecyclerMainBinding;

import java.util.ArrayList;

public class BindMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_main);


        ActivityBindMainBinding activityMainBinding;
        String str;


        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ArrayList<City> cityArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            City city = new City();
            city.setId(i + 1);
            city.setCityName("City" + i);
            city.setCode("Code" + i);
            cityArrayList.add(city);

//            activityMainBinding.spnCity.setAdapter(new SpinnerAdapter(this, cityArrayList));
            activityMainBinding.spnCity.setAdapter(new SpinnerAdapter(this, cityArrayList));
            User user = new User();
            user.setUserName("Samadhan");
            user.setGender("Male");
//        user.setLanguage("Marathi");
            user.setEmail("samadhanmedge@gmail.com");
            user.setCity(cityArrayList.get(5));
            activityMainBinding.setUser(user);
            activityMainBinding.btnAdd.setOnClickListener(view -> {
                System.out.println("===User:userName:" + activityMainBinding.getUser().getUserName()
                        + ", Email:" + activityMainBinding.getUser().getEmail()
                        + ", Gender:" + activityMainBinding.getUser().getGender()
                        + ", Language:" + activityMainBinding.getUser().getLanguage()
                        + ", City:" + activityMainBinding.getUser().getCity().getCityName());
            });
        }
    }
}