package com.example.newsapp;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Url_Layout_Activity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url_layout);

        webView = findViewById(R.id.webView);

        String newsUrl = getIntent().getExtras().getString("url");
        webView.loadUrl(newsUrl);



    }
}
