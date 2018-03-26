package com.semicolon.eslamy.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import com.semicolon.eslamy.R;

public class WebViewActivity extends AppCompatActivity {

    private String url;
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        getDataFromIntent();
        webView =  findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }

    private void getDataFromIntent() {

        Intent intent = getIntent();
        if (intent!=null)
        {
            url=intent.getStringExtra("url");
            Toast.makeText(this, ""+url, Toast.LENGTH_SHORT).show();
        }
    }
}
