package com.techburst.st_anthony_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.techburst.st_anthony_app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.llWebsite.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WebView.class);
            intent.putExtra("url","http://stanthonyschooledu.org");
            startActivity(intent);
        });

        binding.llPortal.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WebView.class);
            intent.putExtra("url","https://stanthonyschooledu.org/login");
            startActivity(intent);
        });
    }
}