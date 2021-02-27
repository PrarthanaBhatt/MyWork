package com.prarthana.myworkapplication.layout.MyRelative;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.prarthana.myworkapplication.R;
import com.prarthana.myworkapplication.layout.MyConstraint.MyConstraintLayoutActivity;
import com.prarthana.myworkapplication.layout.layout_dashboard.DashboardLayoutActivity;

public class MyRelativeLayoutActivity extends AppCompatActivity {

    Button arrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_my_relative_layout);

        arrow = findViewById(R.id.arrow);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MyConstraintLayout.this, "constraint Layout clicked..", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MyRelativeLayoutActivity.this, DashboardLayoutActivity.class);
                startActivity(intent);
            }
        });
    }
}