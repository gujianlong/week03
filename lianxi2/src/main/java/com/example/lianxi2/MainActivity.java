package com.example.lianxi2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lianxi2.base.BaseActivity;
import com.example.lianxi2.base.BasePresenter;
import com.example.lianxi2.bean.Dbean;
import com.example.lianxi2.presenter.Presenter;
import com.google.gson.Gson;

import java.util.HashMap;

public class MainActivity extends BaseActivity {
    private String str = "http://172.17.8.100/small/user/v1/login";

    private EditText edit_name;
    private EditText edit_pwd;
    private Button button_d;
    private Button button_z;

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        edit_name = findViewById(R.id.edit_name);
        edit_pwd = findViewById(R.id.edit_pwd);
        button_d = findViewById(R.id.button_D);
        button_z = findViewById(R.id.button_Z);
        button_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_name.getText().toString().trim();
                String pwd = edit_pwd.getText().toString().trim();
                if (name.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(MainActivity.this, "账号密码密不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("phone", name);
                    map.put("pwd", pwd);
                    mPresenter.startRequest(str, map);
                }
            }
        });
        button_z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ZhuCeActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    public void onSuccess(String json) {
        Gson gson = new Gson();
        Dbean dbean = gson.fromJson(json, Dbean.class);
        Dbean.ResultBean result = dbean.getResult();
        String message = dbean.getMessage();
        if (message.equals("登录成功")) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            String headPic = result.getHeadPic();
            intent.putExtra("headPic", headPic);
            startActivity(intent);
        }
    }

    @Override
    public void onError(String json) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200) {
            String phone = data.getStringExtra("phone");
            String pwd = data.getStringExtra("pwd");
            edit_name.setText(phone);
            edit_pwd.setText(pwd);
        }
    }
}
