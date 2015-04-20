package com.sunshine.bbreaker.appet_i;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

/**
 * Created by niteshkp on 22/3/15.
 */
public class ListViewAdapter extends ArrayAdapter {
    private LayoutInflater inflater;

    public ListViewAdapter(Activity activity, String[] items){
        super(activity, R.layout.homelistviewlayout, items);
        inflater = activity.getWindow().getLayoutInflater();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        return inflater.inflate(R.layout.homelistviewlayout, parent, false);


    }

}
