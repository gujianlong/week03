package com.example.lianxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lianxi.base.BaseActivity;
import com.example.lianxi.base.BasePresenter;
import com.example.lianxi.bean.Zbean;
import com.example.lianxi.presenter.Presenter;
import com.google.gson.Gson;

import java.util.HashMap;

public class ZhuCeActivity extends BaseActivity {
    private String str = "http://172.17.8.100/small/user/v1/register";
    private EditText edir_pwd;
    private EditText edir_name;
    private Button button_z;

    @Override
    protected int layoutId() {
        return R.layout.activity_zhu_ce;
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
        button_z = findViewById(R.id.button_Z);
        button_z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pwd = edir_pwd.getText().toString().trim();
                String name = edir_name.getText().toString().trim();
                if (pwd.isEmpty() && name.isEmpty()) {
                    Toast.makeText(ZhuCeActivity.this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                HashMap<String, String> map = new HashMap<>();
                map.put("phone", name);
                map.put("pwd", pwd);
                mPresenter.startRequest(str, map);
            }
        });
    }

    @Override
    public void onSuccess(String json) {
        Gson gson = new Gson();
        Zbean zbean = gson.fromJson(json, Zbean.class);
        String message = zbean.getMessage();
        String status = zbean.getStatus();
        if (message.equals("0000") || status.equals("1001")) {
            Intent intent = new Intent(ZhuCeActivity.this, MainActivity.class);
            intent.putExtra("name", edir_name.getText().toString().trim());
            intent.putExtra("pwd", edir_pwd.getText().toString().trim());
            setResult(200, intent);
            finish();
        }
    }

    @Override
    public void onError(String error) {

    }
}
