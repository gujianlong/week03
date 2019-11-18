package com.example.lianxi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.lianxi2.utils.GlideUtil;

public class Main2Activity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView = findViewById(R.id.image);
        Intent intent = getIntent();
        String headPic = intent.getStringExtra("headPic");
        GlideUtil.loadImage(headPic,imageView);

    }
}
