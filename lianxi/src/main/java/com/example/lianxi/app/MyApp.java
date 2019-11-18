package com.example.lianxi.app;
/*
 *@auther:谷建龙
 *@Date: 2019/11/16
 *@Time:11:28
 *@Description:
 * */


import android.app.Application;
import android.content.Context;

public class MyApp extends Application {
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
}
