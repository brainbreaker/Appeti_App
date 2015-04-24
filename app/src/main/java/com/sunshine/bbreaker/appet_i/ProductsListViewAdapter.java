package com.sunshine.bbreaker.appet_i;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by niteshkp on 1/4/15.
 */
public class ProductsListViewAdapter extends BaseAdapter{
    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public ProductsListViewAdapter(Products mainActivity, String[] ProductNameList, int[] ProductImages) {
        // TODO Auto-generated constructor stub
        result=ProductNameList;
        context=mainActivity;
        imageId=ProductImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.productslistviewlayout, null);
        holder.tv=(TextView) rowView.findViewById(R.id.ProductTitle);
        holder.img=(ImageView) rowView.findViewById(R.id.ProductImage);
        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);

        return rowView;
    }

}