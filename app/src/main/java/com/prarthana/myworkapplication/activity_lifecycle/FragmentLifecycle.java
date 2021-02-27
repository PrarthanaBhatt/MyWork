package com.prarthana.myworkapplication.activity_lifecycle;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.prarthana.myworkapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentLifecycle#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLifecycle extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentLifecycle() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentLifecycle.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentLifecycle newInstance(String param1, String param2) {
        FragmentLifecycle fragment = new FragmentLifecycle();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i("FragmentOne","-----** attach fragment **----");
        Toast.makeText(getContext(), "Fragment attach", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("FragmentOne","-----** create fragment **----");
        Toast.makeText(getContext(), "Fragment create", Toast.LENGTH_SHORT).show();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("Fragment","----** create view **----");
        Toast.makeText(getContext(), "Fragment create view", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_lifecycle, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("FragmentOne","----** activity created **----");
        Toast.makeText(getContext(), "Fragment activity created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("FragmentOne","----** start **----");
        Toast.makeText(getContext(), "Fragment started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("FragmentOne","----** resume **----");
        Toast.makeText(getContext(), "Fragment resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("FragmentOne","----** pause **----");

        Toast.makeText(getContext(), "Fragment pause", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("FragmentOne","----** stop **----");
        Toast.makeText(getContext(), "Fragment stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("FragmentOne","----** destroy view **----");
        Toast.makeText(getContext(), "Fragment destroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("FragmentOne","----** destroy **----");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("FragmentOne","---** detach **---");
    }
}
