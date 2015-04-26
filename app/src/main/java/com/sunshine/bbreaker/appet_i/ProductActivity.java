package com.sunshine.bbreaker.appet_i;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class ProductActivity extends ActionBarActivity {

    Button addtocart;
    TextView title;
    TextView description;
    TextView price;
    ImageView productimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);


        Intent productintent = getIntent();
        final String producttitle = productintent.getStringExtra("producttitle");
        getSupportActionBar().setTitle(producttitle);

        addtocart = (Button) findViewById(R.id.AddToCartButton);

        title= (TextView) findViewById(R.id.ProductTitle);
        description= (TextView) findViewById(R.id.ProductDescription);
        price= (TextView) findViewById(R.id.PriceTextView);
        productimage= (ImageView) findViewById(R.id.ProductImage);

        if(producttitle.equals("Paneer Ghewar"))
        {
            productimage.setImageResource(R.drawable.ghewar);
            title.setText("Paneer Ghewar");
            description.setText("");
            price.setText("");
        }
        if(producttitle.equals("Kalakand"))
        {
            productimage.setImageResource(R.drawable.kalakand);
            title.setText("Kalakand");
            description.setText("");
            price.setText("");
        }
        if(producttitle.equals("Bombay Ice Halwa"))
        {
            productimage.setImageResource(R.drawable.icehalwa);
            title.setText("Bombay Ice Halwa");
            description.setText("");
            price.setText("");
        }
        if(producttitle.equals("Kashmiri Chikki"))
        {
            productimage.setImageResource(R.drawable.kashmirichikki);
            title.setText("Kashmiri Chikki");
            description.setText("");
            price.setText("");
        }
        if(producttitle.equals("Khakhra"))
        {
            productimage.setImageResource(R.drawable.khakra);
            title.setText("Gujrati Khakra");
            description.setText("");
            price.setText("");
        }
        if(producttitle.equals("Ratlami Sev"))
        {
            productimage.setImageResource(R.drawable.lehsunsev);
            title.setText("Ratlami Sev");
            description.setText("");
            price.setText("");
        }
        if(producttitle.equals("Mysore Pak"))
        {
            productimage.setImageResource(R.drawable.mysorepak);
            title.setText("Mysore Pak");
            description.setText("");
            price.setText("");
        }
        if(producttitle.equals("Kesar Angoori Petha"))
        {
            productimage.setImageResource(R.drawable.petha);
            title.setText("Kesar Angoori Petha");
            description.setText("");
            price.setText("");
        }
        if(producttitle.equals("Til Ke Laddoo"))
        {
            productimage.setImageResource(R.drawable.tilkeladdoo);
            title.setText("Til Ke Laddoo");
            description.setText("");
            price.setText("");
        }
        addtocart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            Intent opencart = new Intent(getApplicationContext(), Cart.class);
           startActivity(opencart);
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
        getMenuInflater().inflate(R.menu.menu_product, menu);
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
            final View rootView = inflater.inflate(R.layout.fragment_product_detail, container, false);



            return rootView;
        }
    }
}
