package com.example.lianxi.base;
/*
 *@auther:谷建龙
 *@Date: 2019/11/16
 *@Time:17:25
 *@Description:
 * */


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lianxi.contacts.Contacts;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements Contacts.IView {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layoutId() != 0) {
            setContentView(layoutId());
            mPresenter = getPresenter();
            mPresenter.onAttchView(this);
            initView();
            dePresenter();
        }

    }

    protected abstract int layoutId();

    protected abstract void dePresenter();

    protected abstract P getPresenter();

    protected abstract void initView();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDeAttchview();
        }
    }
}
