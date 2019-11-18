package com.bawei.gujianlong20191118;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bawei.gujianlong20191118.utils.GlideUtils;

public class Main2Activity extends AppCompatActivity {

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        image = findViewById(R.id.image);
        Intent intent = getIntent();
        String headPic = intent.getStringExtra("headPic");
        GlideUtils.loadImage(headPic, image);
    }
}
