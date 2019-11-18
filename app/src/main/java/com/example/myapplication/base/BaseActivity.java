package com.example.myapplication.base;
/*
 *@auther:谷建龙
 *@Date: 2019/11/16
 *@Time:9:10
 *@Description:
 * */


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.contacts.Contacts;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements Contacts.IView {
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layoutId() != 0) {
            layoutId();
            initView();
            mPresenter = getPresenter();
            mPresenter.onAttchView(this);
            startCoding();
        }
    }

    protected abstract void startCoding();

    protected abstract P getPresenter();

    protected abstract void initView();

    protected abstract int layoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDeAttchView();
            mPresenter = null;
        }
    }
}
