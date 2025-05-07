package com.example.hwk6;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView webView = findViewById(R.id.webview);

        // Enable JavaScript and allow mixed content
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

        String url = getIntent().getStringExtra("news_url");
        if (url != null && !url.isEmpty()) {
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(url);
        } else {
            Toast.makeText(this, "Error: No URL found.", Toast.LENGTH_SHORT).show();
        }
    }
}
