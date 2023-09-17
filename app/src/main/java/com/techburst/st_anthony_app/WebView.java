package com.techburst.st_anthony_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
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
        binding.webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(android.webkit.WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                binding.progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(android.webkit.WebView view, String url) {
                super.onPageFinished(view, url);
                binding.progressBar.setVisibility(View.GONE);
            }
        });

        // Set WebChromeClient for progress updates
        binding.webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(android.webkit.WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                binding.progressBar.setProgress(newProgress);
            }
        });

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