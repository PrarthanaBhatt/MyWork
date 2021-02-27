package com.prarthana.myworkapplication.activity_lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.prarthana.myworkapplication.R;

public class LifecycleMainActivity extends AppCompatActivity {

    private final int DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_main);
        Log.i("MainActivity","Create Activity.....");
        Toast.makeText(this, "Activity Created...", Toast.LENGTH_SHORT).show();

        //lambda funtion to onclicklistener
        findViewById(R.id.btn).setOnClickListener(view -> Toast.makeText(this, "Button clicked", Toast.LENGTH_LONG).show());
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity","Start Activity.....");
        Toast.makeText(this, "Activity started...", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FragmentManager manager = getSupportFragmentManager();
                int count = manager.getBackStackEntryCount();

                getSupportFragmentManager().popBackStack();

                FragmentTransaction ft = manager.beginTransaction();
                ft.replace(R.id.mainContener, new FragmentLifecycle());
                ft.commit();
            }
        }, DISPLAY_LENGTH);




    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity","Resume Activity.....");
        Toast.makeText(this, "Activity Resume...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity","Restart Activity.....");
        Toast.makeText(this, "Activity Restart...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity","Pause Activity.....");
        Toast.makeText(this, "Activity Pause...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity","Stop Activity.....");
        Toast.makeText(this, "Activity Stop...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity","Destroy Activity.....");
        Toast.makeText(this, "Activity Destroy...", Toast.LENGTH_SHORT).show();
    }

}
