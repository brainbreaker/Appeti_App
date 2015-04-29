////package com.sunshine.bbreaker.appet_i;
////
////import android.support.v7.app.ActionBarActivity;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Random;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.message.BasicNameValuePair;
//
//
//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.content.Intent;
//import android.net.http.SslError;
//import android.os.AsyncTask;
//import android.os.Build;
//import android.os.Bundle;
//import android.os.Handler;
//import android.provider.SyncStateContract.Constants;
//import android.util.Log;
//import android.view.View;
//import android.view.Window;
//import android.webkit.JsResult;
//import android.webkit.SslErrorHandler;
//import android.webkit.WebChromeClient;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//
//import android.widget.Toast;
//
//@SuppressLint("SetJavaScriptEnabled")
//
//
//public class PayMentGateWay extends Activity {
//    private ArrayList<String> post_val = new ArrayList<String>();
//    private String post_Data="";
//    WebView webView ;
//    final Activity activity = this;
//    private String tag = "PayMentGateWay";
//    private String hash,hashSequence;
//
//    String merchant_key="JBZaLc";
//    String salt="GQs7yium";
//    String action1 ="";
//    String base_url="https://test.payu.in";
//    int error=0;
//    String hashString="";
//    Map<String,String> params;
//    String txnid ="";
//
//    Handler mHandler = new Handler();
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        // TODO Auto-generated method stub
//        super.onCreate(savedInstanceState);
//        final ProgressDialog progressDialog = new ProgressDialog(activity);
//        getWindow().requestFeature(Window.FEATURE_PROGRESS);
//        webView = new WebView(this);
//        setContentView(webView);
//
//
//
//        post_val = getIntent().getStringArrayListExtra("post_val");
//        Log.d(tag, "post_val: "+post_val);
//        params= new HashMap<String,String>();
//        for(int i = 0;i<post_val.size();){
//            params.put(post_val.get(i), post_val.get(i+1));
//            i+=2;
//
//        }
//
//
//        if(empty(params.get("txnid"))){
//            Random rand = new Random();
//            String rndm = Integer.toString(rand.nextInt())+(System.currentTimeMillis() / 1000L);
//            txnid=hashCal("SHA-256",rndm).substring(0,20);
//        }
//        else
//            txnid=params.get("txnid");
//        //String udf2 = txnid;
//        String txn="abcd";
//        hash="";
//        String hashSequence = "key|txnid|amount|productinfo|firstname|email|udf1|udf2|udf3|udf4|udf5|udf6|udf7|udf8|udf9|udf10";
//        if(empty(params.get("hash")) && params.size()>0)
//        {
//            if( empty(params.get("key"))
//                    || empty(params.get("txnid"))
//                    || empty(params.get("amount"))
//                    || empty(params.get("firstname"))
//                    || empty(params.get("email"))
//                    || empty(params.get("phone"))
//                    || empty(params.get("productinfo"))
//                    || empty(params.get("surl"))
//                    || empty(params.get("furl"))
//                    || empty(params.get("service_provider"))
//
//                    )
//
//                error=1;
//            else{
//                String[] hashVarSeq=hashSequence.split("\\|");
//
//                for(String part : hashVarSeq)
//                {
//                    hashString= (empty(params.get(part)))?hashString.concat(""):hashString.concat(params.get(part));
//                    hashString=hashString.concat("|");
//                }
//                hashString=hashString.concat(salt);
//
//
//                hash=hashCal("SHA-512",hashString);
//                action1=base_url.concat("/_payment");
//            }
//        }
//        else if(!empty(params.get("hash")))
//        {
//            hash=params.get("hash");
//            action1=base_url.concat("/_payment");
//        }
//
//        webView.setWebViewClient(new WebViewClient(){
//
//
//            @Override
//            public void onReceivedError(WebView view, int errorCode,
//                                        String description, String failingUrl) {
//                // TODO Auto-generated method stub
//                Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onReceivedSslError(WebView view,
//                                           SslErrorHandler handler, SslError error) {
//                // TODO Auto-generated method stub
//                Toast.makeText(activity, "SslError! " +  error, Toast.LENGTH_SHORT).show();
//                handler.proceed();
//            }
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                // TODO Auto-generated method stub
//                return super.shouldOverrideUrlLoading(view, url);
//            }
//
//
//        });
//
//
//        webView.setVisibility(View.INVISIBLE);
//        webView.getSettings().setBuiltInZoomControls(true);
//        webView.getSettings().setCacheMode(2);
//        webView.getSettings().setDomStorageEnabled(true);
//        webView.clearHistory();
//        webView.clearCache(true);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setSupportZoom(true);
//        webView.getSettings().setUseWideViewPort(false);
//        webView.getSettings().setLoadWithOverviewMode(false);
//
//        webView.addJavascriptInterface(new PayUJavaScriptInterface(activity), "PayUMoney");
//        Map<String, String> mapParams = new HashMap<String, String>();
//        mapParams.put("key",merchant_key);
//        mapParams.put("hash",PayMentGateWay.this.hash);
//        mapParams.put("txnid",(empty(PayMentGateWay.this.params.get("txnid"))) ? "" : PayMentGateWay.this.params.get("txnid"));
//        Log.d(tag, "txnid: "+PayMentGateWay.this.params.get("txnid"));
//        mapParams.put("service_provider","payu_paisa");
//
//        mapParams.put("amount",(empty(PayMentGateWay.this.params.get("amount"))) ? "" : PayMentGateWay.this.params.get("amount"));
//        mapParams.put("firstname",(empty(PayMentGateWay.this.params.get("firstname"))) ? "" : PayMentGateWay.this.params.get("firstname"));
//        mapParams.put("email",(empty(PayMentGateWay.this.params.get("email"))) ? "" : PayMentGateWay.this.params.get("email"));
//        mapParams.put("phone",(empty(PayMentGateWay.this.params.get("phone"))) ? "" : PayMentGateWay.this.params.get("phone"));
//
//        mapParams.put("productinfo",(empty(PayMentGateWay.this.params.get("productinfo"))) ? "" : PayMentGateWay.this.params.get("productinfo"));
//        mapParams.put("surl",(empty(PayMentGateWay.this.params.get("surl"))) ? "" : PayMentGateWay.this.params.get("surl"));
//        mapParams.put("furl",(empty(PayMentGateWay.this.params.get("furl"))) ? "" : PayMentGateWay.this.params.get("furl"));
//        mapParams.put("lastname",(empty(PayMentGateWay.this.params.get("lastname"))) ? "" : PayMentGateWay.this.params.get("lastname"));
//
//        mapParams.put("address1",(empty(PayMentGateWay.this.params.get("address1"))) ? "" : PayMentGateWay.this.params.get("address1"));
//        mapParams.put("address2",(empty(PayMentGateWay.this.params.get("address2"))) ? "" : PayMentGateWay.this.params.get("address2"));
//        mapParams.put("city",(empty(PayMentGateWay.this.params.get("city"))) ? "" : PayMentGateWay.this.params.get("city"));
//        mapParams.put("state",(empty(PayMentGateWay.this.params.get("state"))) ? "" : PayMentGateWay.this.params.get("state"));
//
//        mapParams.put("country",(empty(PayMentGateWay.this.params.get("country"))) ? "" : PayMentGateWay.this.params.get("country"));
//        mapParams.put("zipcode",(empty(PayMentGateWay.this.params.get("zipcode"))) ? "" : PayMentGateWay.this.params.get("zipcode"));
//        mapParams.put("udf1",(empty(PayMentGateWay.this.params.get("udf1"))) ? "" : PayMentGateWay.this.params.get("udf1"));
//        mapParams.put("udf2",(empty(PayMentGateWay.this.params.get("udf2"))) ? "" : PayMentGateWay.this.params.get("udf2"));
//
//        mapParams.put("udf3",(empty(PayMentGateWay.this.params.get("udf3"))) ? "" : PayMentGateWay.this.params.get("udf3"));
//        mapParams.put("udf4",(empty(PayMentGateWay.this.params.get("udf4"))) ? "" : PayMentGateWay.this.params.get("udf4"));
//        mapParams.put("udf5",(empty(PayMentGateWay.this.params.get("udf5"))) ? "" : PayMentGateWay.this.params.get("udf5"));
//        mapParams.put("pg",(empty(PayMentGateWay.this.params.get("pg"))) ? "" : PayMentGateWay.this.params.get("pg"));
//        webview_ClientPost(webView, action1, mapParams.entrySet());
//
//    }
//    public class PayUJavaScriptInterface {
//        Context mContext;
//
//        /** Instantiate the interface and set the context */
//        PayUJavaScriptInterface(Context c) {
//            mContext = c;
//        }
//
//
//        public void success(long id, final String paymentId) {
//
//            mHandler.post(new Runnable() {
//
//                public void run() {
//
//                    mHandler = null;
//
//                    Intent intent = new Intent(PayMentGateWay.this, Home.class);
//
//                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_SINGLE_TOP);
//
//                    intent.putExtra("result", "success");
//
//                    intent.putExtra("paymentId", paymentId);
//
//                    startActivity(intent);
//
//                    finish();
//
//                }
//
//            });
//
//        }
//
//    }
//    public void webview_ClientPost(WebView webView, String url, Collection< Map.Entry<String, String>> postData){
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("<html><head></head>");
//        sb.append("<body onload='form1.submit()'>");
//        sb.append(String.format("<form id='form1' action='%s' method='%s'>", url, "post"));
//        for (Map.Entry<String, String> item : postData) {
//            sb.append(String.format("<input name='%s' type='hidden' value='%s' />", item.getKey(), item.getValue()));
//        }
//        sb.append("</form></body></html>");
//        Log.d(tag, "webview_ClientPost called");
//        webView.loadData(sb.toString(), "text/html", "utf-8");
//    }
//
//
//    public void success(long id, final String paymentId) {
//
//        mHandler.post(new Runnable() {
//
//            public void run() {
//
//                mHandler = null;
//
//                Intent intent = new Intent(PayMentGateWay.this, Home.class);
//
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_SINGLE_TOP);
//
//                intent.putExtra(Constants.ACCOUNT_NAME, "success");
//
//                intent.putExtra(Constants._ID, paymentId);
//
//                startActivity(intent);
//
//                finish();
//
//            }
//
//        });
//
//    }
//
//
//    public boolean empty(String s)
//    {
//        if(s== null || s.trim().equals(""))
//            return true;
//        else
//            return false;
//    }
//
//    public String hashCal(String type,String str){
//        byte[] hashseq=str.getBytes();
//        StringBuffer hexString = new StringBuffer();
//        try{
//            MessageDigest algorithm = MessageDigest.getInstance(type);
//            algorithm.reset();
//            algorithm.update(hashseq);
//            byte messageDigest[] = algorithm.digest();
//
//
//
//            for (int i=0;i<messageDigest.length;i++) {
//                String hex=Integer.toHexString(0xFF & messageDigest[i]);
//                if(hex.length()==1) hexString.append("0");
//                hexString.append(hex);
//            }
//
//        }catch(NoSuchAlgorithmException nsae){ }
//
//        return hexString.toString();
//
//
//    }
//
//
//
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_pay_ment_gate_way, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
