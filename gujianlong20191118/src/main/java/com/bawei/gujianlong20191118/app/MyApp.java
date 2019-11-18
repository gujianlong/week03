package com.bawei.gujianlong20191118.app;
/*
 *@auther:谷建龙
 *@Date: 2019/11/18
 *@Time:8:56
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
