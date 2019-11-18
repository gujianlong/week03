package com.bawei.gujianlong20191118;

import androidx.annotation.Nullable;
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
import com.bawei.gujianlong20191118.bean.Dbean;
import com.bawei.gujianlong20191118.presenter.Presenter;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {
    private String str = "http://172.17.8.100/small/user/v1/login";
    private EditText edit_phone;
    private EditText edit_pwd;
    private Button button_d;
    private Button button_z;

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        edit_phone = findViewById(R.id.edit_phone);
        edit_pwd = findViewById(R.id.edit_pwd);
        button_d = findViewById(R.id.button_D);
        button_z = findViewById(R.id.button_Z);


        button_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit_pwd = MainActivity.this.edit_pwd.getText().toString().trim();
                String edit_phone = MainActivity.this.edit_phone.getText().toString().trim();
                if (edit_phone.isEmpty() && edit_pwd.isEmpty()) {
                    Toast.makeText(MainActivity.this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    Map<String, String> map = new HashMap<>();
                    map.put("phone", edit_phone);
                    map.put("pwd", edit_pwd);
                    mPresenter.startRequest(str, map);
                }
            }
        });
        button_z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ZhuceActivity.class);
                startActivityForResult(intent, 100);
                finish();
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onMySuccess(String json) {
        Gson gson = new Gson();
        Dbean dbean = gson.fromJson(json, Dbean.class);
        String message = dbean.getMessage();
        String status = dbean.getStatus();
        Log.e("TAG", "onMySuccess: " + message);
        Dbean.ResultBean result = dbean.getResult();
        if (status.equals("0000")) {
            String headPic = result.getHeadPic();
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            intent.putExtra("headPic",headPic);
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
            String phone = data.getStringExtra("edit_phone");
            String pwd = data.getStringExtra("edit_pwd");
            edit_phone.setText(phone);
            edit_pwd.setText(pwd);
        }
    }
}
