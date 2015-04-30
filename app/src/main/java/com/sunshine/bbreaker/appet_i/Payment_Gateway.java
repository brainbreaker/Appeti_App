package com.sunshine.bbreaker.appet_i;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


public class Payment_Gateway extends ActionBarActivity {
WebView webView;
    ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment__gateway);


        webView = (WebView) findViewById(R.id.webview);
        progress = (ProgressBar) findViewById(R.id.progressBar);
        progress.setMax(100);
        gotoPage();
        //Button button = (Button) findViewById (R.id.button);
       // button.setOnClickListener(new View.OnClickListener() {
          //  @Override
          ///  public void onClick(View v) {

         //   }
       // });

    }

    private void gotoPage(){
        Intent intent = getIntent();
        final String PTitle= intent.getStringExtra("productname");
        String url= null;
        if (PTitle.equals("Paneer Ghewar")) {
           url = "http://www.google.com";
        }
        else  if (PTitle.equals("Gujrati Khakra")) {
            url = "http://www.google.com";
        }
        else  if (PTitle.equals("Mysore Pak")) {
            url = "http://www.google.com";
        }
        else  if (PTitle.equals("Bombay Ice Halwa")) {
            url = "http://www.google.com";
        }
        else  if (PTitle.equals("Kesar Angoori Petha")) {
            url = "http://www.google.com";
        }
        else  if (PTitle.equals("Kalakand")) {
            url = "http://www.google.com";
        }
        else  if (PTitle.equals("Kashmiri Chikki")) {
            url = "http://www.google.com";
        }
        else  if (PTitle.equals("Ratlami Sev")) {
            url = "http://www.google.com";
        }
        else  if (PTitle.equals("Til Ke Laddoo")) {
            url = "http://www.appeti.in/cart/";
        }
        Toast.makeText(this, "oops \t" + url, Toast.LENGTH_SHORT).show();

        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);

        webView.setWebViewClient(new Callback());  //HERE IS THE MAIN CHANGE
        webView.loadUrl(url);

    }

    private class Callback extends WebViewClient{  //HERE IS THE MAIN CHANGE.

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return (false);
        }

    }











    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_payment__gateway, menu);
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
