package com.prarthana.myworkapplication.architecture.mvvm_architecture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.prarthana.myworkapplication.R;
import com.prarthana.myworkapplication.architecture.mvvm_architecture.view_model.AppViewModel;
import com.prarthana.myworkapplication.databinding.ActivityMvvmMainBinding;

public class MvvmMainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm_main);

        // ViewModel updates the Model
        // after observing changes in the View

        // model will also update the view
        // via the ViewModel
        ActivityMvvmMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(new AppViewModel());
        activityMainBinding.executePendingBindings();
    }

    // any change in toastMessage attribute
    // defined on the Button with bind prefix
    // invokes this method
    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
