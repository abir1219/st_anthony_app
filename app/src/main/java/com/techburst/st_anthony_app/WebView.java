package com.techburst.st_anthony_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;

import com.techburst.st_anthony_app.databinding.ActivityWebViewBinding;

public class WebView extends AppCompatActivity {
    ActivityWebViewBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String url= getIntent().getStringExtra("url");
        loadUrl(url);
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void loadUrl(String url) {
        System.out.println(url);
        binding.webView.getSettings().setJavaScriptEnabled(true); // Enable JavaScript if needed
        binding.webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        binding.webView.clearCache(true);
        binding.webView.clearHistory();
        binding.webView.setWebViewClient(new WebViewClient());
        binding.webView.loadUrl(url); // Replace with the desired URL
    }

    @Override
    public void onBackPressed() {
        if(binding.webView.canGoBack()){
            binding.webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}