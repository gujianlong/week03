package com.example.lianxi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lianxi2.base.BaseActivity;
import com.example.lianxi2.base.BasePresenter;
import com.example.lianxi2.bean.Zbean;
import com.example.lianxi2.presenter.Presenter;
import com.google.gson.Gson;

import java.util.HashMap;

public class ZhuCeActivity extends BaseActivity {
    private String str = "http://172.17.8.100/small/user/v1/register";
    private EditText edit_name;
    private EditText edit_pwd;
    private Button button_z;

    @Override
    protected int layoutId() {
        return R.layout.activity_zhu_ce;
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        edit_name = findViewById(R.id.edit_name);
        edit_pwd = findViewById(R.id.edit_pwd);
        button_z = findViewById(R.id.button_Z);
        button_z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_pwd.getText().toString().trim();
                String pwd = edit_pwd.getText().toString().trim();
                if (name.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(ZhuCeActivity.this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("phone", name);
                    map.put("pwd", pwd);
                    mPresenter.startRequest(str, map);
                }
            }
        });
    }

    @Override
    public void onSuccess(String json) {
        Gson gson = new Gson();
        Zbean zbean = gson.fromJson(json, Zbean.class);
        String message = zbean.getMessage();
        String status = zbean.getStatus();
        if (status.equals("0000") || status.equals("1001")) {
            Intent intent = new Intent(ZhuCeActivity.this, MainActivity.class);
            intent.putExtra("phone", edit_name.getText().toString().trim());
            intent.putExtra("pwd", edit_pwd.getText().toString().trim());
            setResult(200, intent);
            finish();
        }
    }

    @Override
    public void onError(String json) {

    }
}
