package com.prarthana.myworkapplication.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.prarthana.myworkapplication.R;
import com.prarthana.myworkapplication.layout.MyConstraint.MyConstraintLayoutActivity;
import com.prarthana.myworkapplication.layout.MyLinear.MyLinearLayoutActivity;
import com.prarthana.myworkapplication.layout.MyRelative.MyRelativeLayoutActivity;

public class LayoutMainActivity extends AppCompatActivity {

    Button linear,relative,constraint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_layout_main);

        linear = findViewById(R.id.linear);
        relative = findViewById(R.id.relative);
        constraint = findViewById(R.id.constraint);
    }

    public void callLinearLayout(View view) {
        Intent intent = new Intent(LayoutMainActivity.this, MyLinearLayoutActivity.class);
        startActivity(intent);
    }

    public void callRelativeLayout(View view) {
        Intent intent = new Intent(LayoutMainActivity.this, MyRelativeLayoutActivity.class);
        startActivity(intent);
    }

    public void callConstraintLayout(View view) {
        Intent intent = new Intent(LayoutMainActivity.this, MyConstraintLayoutActivity.class);
        startActivity(intent);
    }
}
