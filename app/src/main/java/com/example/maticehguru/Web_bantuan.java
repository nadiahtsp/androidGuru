package com.example.maticehguru;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

import com.example.maticehguru.R;

public class Web_bantuan extends Activity {

    WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_layout);
        webView = (WebView)findViewById(R.id.bantuan);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.maticeh.invicit.com/bantuan");
        webView.setWebViewClient(new WebViewController());

    };
}
