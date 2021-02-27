package com.prarthana.myworkapplication.data_persistence.shared_pref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.prarthana.myworkapplication.R;

public class SharedPrefActivity extends AppCompatActivity {


    EditText lgEmail,lgPassword;
    String strLoginEmail,strLoginPassword;
    Button btnLogin;
    CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        SharedPreferences prefs = getSharedPreferences("MY_APP_LOGIN", MODE_PRIVATE);
        String name = prefs.getString("USER", "");
        String pswd = prefs.getString("PASSWORD", "");

        Toast.makeText(this, name+pswd, Toast.LENGTH_SHORT).show();



        lgEmail = findViewById(R.id.lgEmail);
        lgPassword = findViewById(R.id.lgPassword);

        lgEmail.setText(name);
        lgPassword.setText(pswd);

        btnLogin = findViewById(R.id.btnLogin);

        checkbox=(CheckBox)findViewById(R.id.checkbox);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strLoginEmail = lgEmail.getText().toString();
                strLoginPassword = lgPassword.getText().toString();

                if(strLoginEmail.equalsIgnoreCase("")){
                    Toast.makeText(SharedPrefActivity.this, "Enter Username", Toast.LENGTH_SHORT).show();
                    return;
                }else if(strLoginPassword.equalsIgnoreCase("")){
                    Toast.makeText(SharedPrefActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                //validation of fileds
                if (strLoginEmail.isEmpty()) {
                    lgEmail.requestFocus();
                    lgEmail.setError("Please enter email");
                    return;
                }
                if (strLoginPassword.isEmpty()) {
                    lgPassword.requestFocus();
                    lgPassword.setError("Please enter password");
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(strLoginEmail).matches()) {
                    lgEmail.requestFocus();
                    lgEmail.setError("Please enter correct email");
                    return;
                }
                if (strLoginPassword.length() < 3) {
                    lgPassword.requestFocus();
                    lgPassword.setError("Please enter password");
                    return;
                }
                if(checkbox.isChecked()){
                    SharedPreferences preferences = getApplicationContext().getSharedPreferences("MY_APP_LOGIN", Context.MODE_PRIVATE);
                    preferences.edit().putString("USER",strLoginEmail).apply();
                    preferences.edit().putString("PASSWORD",strLoginPassword).apply();
                    Toast.makeText(SharedPrefActivity.this, strLoginEmail+strLoginPassword, Toast.LENGTH_SHORT).show();

                }else{
                    SharedPreferences preferences = getApplicationContext().getSharedPreferences("MY_APP_LOGIN",Context.MODE_PRIVATE);
                    preferences.edit().clear();
                    preferences.edit().apply();
                    finish();
                    Toast.makeText(SharedPrefActivity.this, "Login Successful...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}