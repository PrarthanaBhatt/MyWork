package com.prarthana.myworkapplication.data_binding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.prarthana.myworkapplication.R;

import java.util.ArrayList;

public class SpinnerAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private ArrayList<City> cityArrayList;

    public SpinnerAdapter(Context context, ArrayList<City> cityArrayList) {
        layoutInflater = LayoutInflater.from(context);
        this.cityArrayList = cityArrayList;
    }

    @Override
    public int getCount() {
        return cityArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return cityArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.spinner_item, null);
        TextView value = view.findViewById(R.id.value);
        if (null != cityArrayList.get(position)) {
            value.setText(cityArrayList.get(position).getCityName());
        }
        return view;
    }
}
