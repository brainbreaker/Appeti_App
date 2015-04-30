package com.sunshine.bbreaker.appet_i;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class Checkout extends ActionBarActivity {
    EditText NameET;
    EditText PhoneET;
    EditText EmailET;
    EditText AddressET;
    EditText CityET;
    EditText PinET;
    EditText StateET;
    String Name;
    String Phone;
    String Email;
    String Address;
    String City;
    String Pin;
    String State;
    Spinner spinner;
    Button confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        NameET= (EditText) findViewById(R.id.Name);
        PhoneET= (EditText) findViewById(R.id.Phone);
        EmailET= (EditText) findViewById(R.id.Email);
        AddressET= (EditText) findViewById(R.id.Address);
        CityET= (EditText) findViewById(R.id.City);
        PinET= (EditText) findViewById(R.id.Pincode);

        Name= NameET.getText().toString();
        Phone=PhoneET.getText().toString();
        Email=EmailET.getText().toString();
        Address=AddressET.getText().toString();
        City=CityET.getText().toString();
        Pin=PinET.getText().toString();



        Intent producttitle = getIntent();
        final String PTitle= producttitle.getStringExtra("PName");

        confirm= (Button) findViewById(R.id.ConfirmButton);


        confirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent opencart = new Intent(getApplicationContext(), Order_Summary.class);

                opencart.putExtra("ShippingAddress", Address);
                opencart.putExtra("PTitle", PTitle);
                startActivity(opencart);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_checkout, menu);
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
