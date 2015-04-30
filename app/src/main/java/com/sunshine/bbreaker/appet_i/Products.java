package com.sunshine.bbreaker.appet_i;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Products extends ActionBarActivity {
    private ListView ProductlistView;
    ProductsListViewAdapter Adapter;



    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        ProductlistView = (ListView) findViewById(R.id.productslistView);
        context = this;

        Intent intent = getIntent();
        final String title = intent.getStringExtra("title");
        getSupportActionBar().setTitle(title);

        /* Using if else to change the values in the array */

        if(title.equals("Rajasthan")){

            int [] ProductImages={R.drawable.ghewar,R.drawable.tilkeladdoo, R.drawable.kalakand};
             String [] ProductNameList={"Paneer Ghewar","Til Ke Laddoo", "Kalakand"};

            Adapter=new ProductsListViewAdapter( this, ProductNameList, ProductImages  );
        }
        else if(title.equals("Gujarat"))
        {
            int [] ProductImages={R.drawable.khakra};
            String [] ProductNameList={"Gujrati Khakra"};

            Adapter=new ProductsListViewAdapter( this, ProductNameList, ProductImages  );

        }
        else if(title.equals("Maharashtra"))
        {
            int [] ProductImages={R.drawable.icehalwa};
            String [] ProductNameList={"Bombay Ice Halwa"};

            Adapter=new ProductsListViewAdapter( this, ProductNameList, ProductImages  );

        }
        else if(title.equals("Uttar Pradesh"))
        {
            int [] ProductImages={R.drawable.petha};
            String [] ProductNameList={"Kesar Angoori Petha",};

            Adapter=new ProductsListViewAdapter( this, ProductNameList, ProductImages  );

        }
        else if(title.equals("Haryana"))
        {
            int [] ProductImages={R.drawable.appetilogo};
            String [] ProductNameList={"Sorry, Currently no items Available in this category"};

            Adapter=new ProductsListViewAdapter( this, ProductNameList, ProductImages  );

        }
        else if(title.equals("Jammu and Kashmir"))
        {
            int [] ProductImages={R.drawable.kashmirichikki};
            String [] ProductNameList={"Kashmiri Chikki"};

            Adapter=new ProductsListViewAdapter( this, ProductNameList, ProductImages  );

        }
        else if(title.equals("Karnataka"))
        {
            int [] ProductImages={R.drawable.mysorepak};
            String [] ProductNameList={"Mysore Pak"};

            Adapter=new ProductsListViewAdapter( this, ProductNameList, ProductImages  );

        }
        else if(title.equals("Andhra Pradesh"))
        {
            int [] ProductImages={R.drawable.appetilogo};
            String [] ProductNameList={"Sorry, Currently no items Available in this category"};

            Adapter=new ProductsListViewAdapter( this, ProductNameList, ProductImages  );

        }
        else if(title.equals("Kerela"))
        {
            int [] ProductImages={R.drawable.appetilogo};
            String [] ProductNameList={"Sorry, Currently no items Available in this category"};

            Adapter=new ProductsListViewAdapter( this, ProductNameList, ProductImages  );

        }
        else
        {
            int [] ProductImages={R.drawable.lehsunsev};
            String [] ProductNameList={"Ratlami Sev"};

            Adapter=new ProductsListViewAdapter( this, ProductNameList, ProductImages  );

        }
        

        ProductlistView.setAdapter(Adapter);



        ProductlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("lol", "lol");
                Intent intent = null;

                if(title.equals("Rajasthan")){

                    switch (position) {
                    case 0:
                            intent = new Intent(Products.this, ProductActivity.class);

                            intent.putExtra("producttitle", "Paneer Ghewar");
                            break;
                    case 1:
                            intent = new Intent(Products.this, ProductActivity.class);

                            intent.putExtra("producttitle", "Til Ke Laddoo");
                            break;
                    case 2:
                            intent = new Intent(Products.this, ProductActivity.class);

                            intent.putExtra("producttitle", "Kalakand");
                            break;

                }
                }
               else if(title.equals("Gujarat")){

                    switch (position) {
                        case 0:
                            intent = new Intent(Products.this, ProductActivity.class);

                            intent.putExtra("producttitle", "Gujrati Khakra");
                            break;


                    }
                }
                else if(title.equals("Maharashtra")){

                    switch (position) {
                        case 0:
                            intent = new Intent(Products.this, ProductActivity.class);

                            intent.putExtra("producttitle", "Bombay Ice Halwa ");
                            break;



                    }
                }
                else if(title.equals("Jammu and Kashmir")){

                    switch (position) {
                        case 0:
                            intent = new Intent(Products.this, ProductActivity.class);

                            intent.putExtra("producttitle", "Kashmiri Chikki");
                            break;


                    }
                }
                else if(title.equals("Uttar Pradesh")){

                    switch (position) {
                        case 0:
                            intent = new Intent(Products.this, ProductActivity.class);

                            intent.putExtra("producttitle", "Kesar Angoori Petha");
                            break;

                    }
                }
                else if(title.equals("Karnataka")){

                    switch (position) {
                        case 0:
                            intent = new Intent(Products.this, ProductActivity.class);

                            intent.putExtra("producttitle", "Mysore Pak");
                            break;

                    }
                }
                else if(title.equals("Madhya Pradesh")) {

                    switch (position){

                        case 0:
                            intent = new Intent(Products.this, ProductActivity.class);

                            intent.putExtra("producttitle", "Ratlami Sev");
                            break;
                    }

                    }
                else {

                    intent = new Intent(Products.this, ProductActivity.class);

                    intent.putExtra("producttitle", "No Items Available");

                }
                Products.this.startActivity(intent);
            }
        });


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_products, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_products, container, false);

            return rootView;
        }
    }
}
