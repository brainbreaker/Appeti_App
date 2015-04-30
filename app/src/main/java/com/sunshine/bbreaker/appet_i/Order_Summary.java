package com.sunshine.bbreaker.appet_i;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class Order_Summary extends ActionBarActivity {
    TextView address;
    ImageView Pimage;
    TextView ProductTitle;
    EditText Quantity;
    EditText Amount;
    Button payment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__summary);
        Intent producttitle = getIntent();
        final String PTitle= producttitle.getStringExtra("PTitle");
        final String ShippingAddress=producttitle.getStringExtra("ShippingAddress");

        Pimage = (ImageView) findViewById(R.id.PImage);
        ProductTitle = (TextView) findViewById(R.id.PTitle);
        Quantity = (EditText) findViewById(R.id.QuantityEditText);
        Amount = (EditText) findViewById(R.id.AmountEditText);
        payment= (Button) findViewById(R.id.ProceedToPaymentButton);
        address = (TextView) findViewById(R.id.ShippingAddressTextView);
//        address.setText(ShippingAddress);


        if(PTitle.equals("Paneer Ghewar"))
        {
          ProductTitle.setText(PTitle);
          Quantity.setText("1KG");
          Amount.setText("Rs 600");
        }
        if(PTitle.equals("Til Ke Laddoo"))
        {
            ProductTitle.setText(PTitle);
            Quantity.setText("1KG");
            Amount.setText("Rs 200");
        }
        if(PTitle.equals("Kalakannd"))
        {
            ProductTitle.setText(PTitle);
            Quantity.setText("1KG");
            Amount.setText("Rs 500");
        }
        if(PTitle.equals("Bombay Ice Halwa"))
        {
            ProductTitle.setText(PTitle);
            Quantity.setText("1KG");
            Amount.setText("Rs 1000");
        }
        if(PTitle.equals("Gujrati Khakra"))
        {
            ProductTitle.setText(PTitle);
            Quantity.setText("1KG");
            Amount.setText("Rs 150");
        }
        if(PTitle.equals("Ratlami Sev"))
        {
            ProductTitle.setText(PTitle);
            Quantity.setText("1KG");
            Amount.setText("Rs 500");
        }
        if(PTitle.equals("Kashmiri Chikki"))
        {
            ProductTitle.setText(PTitle);
            Quantity.setText("1KG");
            Amount.setText("Rs 250");
        }
        if(PTitle.equals("Kesar Angoori Petha"))
        {
            ProductTitle.setText(PTitle);
            Quantity.setText("1KG");
            Amount.setText("Rs 500");
        }
        if(PTitle.equals("Mysore Pak"))
        {
            ProductTitle.setText(PTitle);
            Quantity.setText("1KG");
            Amount.setText("Rs 400");
        }
        Quantity.setEnabled(false);
        Amount.setEnabled(false);

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paymentgateway= new Intent(getApplicationContext(), Payment_Gateway.class);
                paymentgateway.putExtra("productname",PTitle);
                paymentgateway.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(paymentgateway);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_order__summary, menu);
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
}
