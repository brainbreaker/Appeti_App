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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Cart extends ActionBarActivity {
    Button checkout;
    TextView ProductTitle;
    ImageView ProductImage;
    EditText Quantity;
    TextView Amount;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Bundle bundle= getIntent().getExtras();
        final String producttitle = bundle.getString("producttitle");
      //  Integer qty = bundle.getInt("quantity");

        ProductTitle=(TextView) findViewById(R.id.ProductTitleTextView);
        ProductImage=(ImageView) findViewById(R.id.ProductImageView);
        Quantity= (EditText) findViewById(R.id.QuantityEditText);
        Amount=(TextView) findViewById(R.id.AmountEditText);
      //  Quantity.setText("1");


        spinner= (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        Integer quantity = null;
        if(spinner.getSelectedItemPosition()==0){

            quantity = 1;

        }
        else{
            quantity = 2;

        }

//        if("".equals(quantity)){
//            Toast toast= Toast.makeText(getApplicationContext(),"Please enter Valid Number in quantity",Toast.LENGTH_SHORT);
//            toast.show();
//        }

        ProductTitle.setText(producttitle);
      //        Quantity.setText(qty +"KG");

        // Setting up of image view based on the product selected
        if(producttitle.equals("Paneer Ghewar"))
        {
        ProductImage.setImageResource(R.drawable.ghewar);
            Amount.setText("Rs"+quantity*600);
        }
        if(producttitle.equals("Til Ke Laddoo"))
        {
            ProductImage.setImageResource(R.drawable.tilkeladdoo);
            Amount.setText("Rs"+quantity*400);
        }

        if(producttitle.equals("Kalakand"))
        {
            ProductImage.setImageResource(R.drawable.kalakand);
            Amount.setText("Rs"+quantity*450);
        }

        if(producttitle.equals("Kesar Angoori Petha"))
        {
            ProductImage.setImageResource(R.drawable.petha);
            Amount.setText("Rs"+quantity*500);
        }

        if(producttitle.equals("Gujarati Khakhra"))
        {
            ProductImage.setImageResource(R.drawable.khakra);
            Amount.setText("Rs"+quantity*150);
        }

        if(producttitle.equals("Mysore Pak"))
        {
            ProductImage.setImageResource(R.drawable.mysorepak);
            Amount.setText("Rs"+quantity*400);
        }

        if(producttitle.equals("Bombay Ice Halwa"))
        {
            ProductImage.setImageResource(R.drawable.icehalwa);
            Amount.setText("Rs"+quantity*1000);
        }

        if(producttitle.equals("Ratlami Sev"))
        {
            ProductImage.setImageResource(R.drawable.lehsunsev);
            Amount.setText("Rs"+quantity*400);
        }

        if(producttitle.equals("Kashmiri Chikki"))
        {
            ProductImage.setImageResource(R.drawable.kashmirichikki);
            Amount.setText("Rs"+quantity*250);
        }



        // OnClickListener for checkout button
        checkout =(Button) findViewById(R.id.checkoutbutton);
        checkout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent opencheckout = new Intent(getApplicationContext(), Checkout.class);
                opencheckout.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                opencheckout.putExtra("PName", producttitle);
                getApplicationContext().startActivity(opencheckout);
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
        getMenuInflater().inflate(R.menu.menu_cart, menu);
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
         Button checkout;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_cart, container, false);


            return rootView;
        }
    }
}
