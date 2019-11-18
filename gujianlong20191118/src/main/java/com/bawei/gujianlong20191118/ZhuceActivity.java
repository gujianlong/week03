package com.bawei.gujianlong20191118;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.gujianlong20191118.base.BaseActivity;
import com.bawei.gujianlong20191118.base.BasePresenter;
import com.bawei.gujianlong20191118.bean.Zbean;
import com.bawei.gujianlong20191118.presenter.Presenter;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class ZhuceActivity extends BaseActivity {
    private String str = "http://172.17.8.100/small/user/v1/register";
    private EditText edit_phone;
    private EditText edit_pwd;
    private Button button_z;

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        edit_phone = findViewById(R.id.edit_phone);
        edit_pwd = findViewById(R.id.edit_pwd);
        button_z = findViewById(R.id.button_Z);

        button_z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit_pwd = ZhuceActivity.this.edit_pwd.getText().toString().trim();
                String edit_phone = ZhuceActivity.this.edit_phone.getText().toString().trim();
                if (edit_phone.isEmpty() && edit_pwd.isEmpty()) {
                    Toast.makeText(ZhuceActivity.this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    Map<String, String> map = new HashMap<>();
                    map.put("phone", edit_phone);
                    map.put("pwd", edit_pwd);
                    mPresenter.startRequest(str, map);
                }
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_zhuce;
    }

    @Override
    public void onMySuccess(String json) {
        Gson gson = new Gson();
        Zbean zbean = gson.fromJson(json, Zbean.class);
        String message = zbean.getMessage();
        String status = zbean.getStatus();
        Log.e("TAG", "onMySuccess: " + message);
        if (status == "0000" || status == "1001") {
            Intent intent = new Intent(ZhuceActivity.this, MainActivity.class);
            intent.putExtra("edit_phone", edit_phone.getText().toString().trim());
            intent.putExtra("edit_pwd", edit_pwd.getText().toString().trim());
            setResult(200, intent);
            finish();
        }
    }

    @Override
    public void onError(String error) {

    }
}
