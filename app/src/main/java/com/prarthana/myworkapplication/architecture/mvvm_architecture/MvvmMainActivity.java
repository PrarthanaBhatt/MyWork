package com.prarthana.myworkapplication.architecture.mvvm_architecture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;

import com.prarthana.myworkapplication.R;

public class MvvmMainActivity extends AppCompatActivity {

    TextView textMessage,textAuthor;
    Button btnRead;

    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm_main);

        textMessage = findViewById(R.id.textMessage);
        textAuthor = findViewById(R.id.textAuthor);
        btnRead = findViewById(R.id.btnRead);

        dialog = new ProgressDialog(this);
        dialog.setMessage("loading");



    }
}
