package com.example.myapplication.app;
/*
 *@auther:谷建龙
 *@Date: 2019/11/16
 *@Time:8:44
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
