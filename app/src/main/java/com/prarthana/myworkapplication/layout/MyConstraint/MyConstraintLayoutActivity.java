package com.prarthana.myworkapplication.layout.MyConstraint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.prarthana.myworkapplication.R;
import com.prarthana.myworkapplication.layout.layout_dashboard.DashboardLayoutActivity;

public class MyConstraintLayoutActivity extends AppCompatActivity {

    Button arrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_my_constraint_layout);

        arrow = findViewById(R.id.arrow);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MyConstraintLayout.this, "constraint Layout clicked..", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MyConstraintLayoutActivity.this, DashboardLayoutActivity.class);
                startActivity(intent);
            }
        });
    }
}
