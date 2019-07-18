package com.example.maticehguru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebKontak extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_kontak);
        webView = (WebView)findViewById(R.id.bantuan);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.maticeh.invicit.com/kontakKami");
        webView.setWebViewClient(new WebViewController());
    }
}
