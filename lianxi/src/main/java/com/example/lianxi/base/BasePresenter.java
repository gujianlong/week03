package com.example.lianxi.base;
/*
 *@auther:谷建龙
 *@Date: 2019/11/16
 *@Time:17:19
 *@Description:
 * */


import android.content.Context;

import com.example.lianxi.contacts.Contacts;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends Contacts.IView> implements Contacts.IPresenter {
    private WeakReference<V> mWeak;

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    protected void onAttchView(V v) {
        mWeak = new WeakReference<>(v);
    }

    protected void onDeAttchview() {
        if (mWeak != null) {
            mWeak.clear();
            mWeak = null;
        }
    }

    protected V getView() {
        return mWeak.get();
    }
}
