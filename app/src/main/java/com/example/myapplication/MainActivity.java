package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.base.BasePresenter;

import java.util.HashMap;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private EditText edir_name;
    private EditText edir_pwd;
    private Button button_D;
    private Button button_Z;

    @Override
    protected void startCoding() {

    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void initView() {

        edir_name = (EditText) findViewById(R.id.edir_name);
        edir_pwd = (EditText) findViewById(R.id.edir_pwd);
        button_D = (Button) findViewById(R.id.button_D);
        button_Z = (Button) findViewById(R.id.button_Z);

        button_D.setOnClickListener(this);
        button_Z.setOnClickListener(this);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(String json) {

    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_D:
                String ed_name = edir_name.getText().toString().trim();
                String ed_pwd = edir_pwd.getText().toString().trim();
                if (ed_name.isEmpty()) {
                    Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (ed_pwd.isEmpty()) {
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                HashMap map=new HashMap();
                
//                mPresenter.startRequest("");

                break;
            case R.id.button_Z:
                Intent intent = new Intent(this, ZhuCeActivity.class);
                startActivityForResult(intent, 100);
                break;
        }
    }
}
