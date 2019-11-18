package com.example.lianxi2.app;
/*
 *@auther:谷建龙
 *@Date: 2019/11/17
 *@Time:14:44
 *@Description:
 * */


import android.app.Application;
import android.content.Context;

public class MyApp extends Application {
    public static Context mContent;

    @Override
    public void onCreate() {
        super.onCreate();
        mContent = this;
    }
}
