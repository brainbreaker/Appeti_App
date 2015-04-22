package com.sunshine.bbreaker.appet_i;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by niteshkp on 1/4/15.
 */
public class ProductsListViewAdapter extends ArrayAdapter {
    private LayoutInflater inflater;

    public ProductsListViewAdapter(Activity activity, String[] items){
        super(activity, R.layout.productslistviewlayout, items);
        inflater = activity.getWindow().getLayoutInflater();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        TextView ProductTitle;
        switch(position){

            

        }
        return inflater.inflate(R.layout.productslistviewlayout, parent, false);


    }

}