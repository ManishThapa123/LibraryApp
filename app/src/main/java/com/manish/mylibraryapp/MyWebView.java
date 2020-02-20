package com.manish.mylibraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebView extends AppCompatActivity {
    private static final String TAG = "MyWebView";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web_view);
        String url = "";

        try {
            url = getIntent().getStringExtra("url");

        }catch (NullPointerException e){
            Log.d(TAG, "onCreate: No intent Created");
        }



        webView = findViewById(R.id.webView);
        //To run in our own Application
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://google.com/");
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();

        }

    }
}
