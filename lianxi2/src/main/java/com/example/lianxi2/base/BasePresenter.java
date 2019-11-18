package com.example.lianxi2.base;
/*
 *@auther:谷建龙
 *@Date: 2019/11/17
 *@Time:15:04
 *@Description:
 * */


import android.provider.Contacts;

import com.example.lianxi2.contract.Contract;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends Contract.IView> implements Contract.IPresenter {
    private WeakReference<V> mWeak;

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    protected void onAttchView(V v) {
        mWeak = new WeakReference<>(v);
    }

    protected void onDeAttchView() {
        if (mWeak != null) {
            mWeak.clear();
            mWeak = null;
        }
    }

    protected V getView() {
        return mWeak.get();
    }
}
