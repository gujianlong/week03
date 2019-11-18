package com.example.lianxi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lianxi.base.BaseActivity;
import com.example.lianxi.base.BasePresenter;
import com.example.lianxi.bean.Dbean;
import com.example.lianxi.presenter.Presenter;
import com.google.gson.Gson;

import java.util.HashMap;

public class MainActivity extends BaseActivity {
    String str = "http://172.17.8.100/small/user/v1/login";
    private EditText edir_name;
    private EditText edir_pwd;
    private Button button_d;
    private Button button_z;

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void dePresenter() {
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        edir_name = findViewById(R.id.edir_name);
        edir_pwd = findViewById(R.id.edir_pwd);
        button_d = findViewById(R.id.button_D);
        button_z = findViewById(R.id.button_Z);

        button_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edir_name = MainActivity.this.edir_name.getText().toString().trim();
                String edir_pwd = MainActivity.this.edir_pwd.getText().toString().trim();
                if (edir_name.isEmpty() && edir_pwd.isEmpty()) {
                    Toast.makeText(MainActivity.this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("phone", edir_name);
                    map.put("pwd", edir_pwd);
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
        String status = dbean.getStatus();
        Dbean.ResultBean result = dbean.getResult();
        if (status.equals("0000")) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            String headPic = result.getHeadPic();
            intent.putExtra("headPic", headPic);
            startActivity(intent);
        }
    }

    @Override
    public void onError(String error) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200) {
            String name = data.getStringExtra("name");
            String pwd = data.getStringExtra("pwd");
            edir_name.setText(name);
            edir_pwd.setText(pwd);
        }
    }
}
