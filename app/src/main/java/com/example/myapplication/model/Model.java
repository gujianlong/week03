package com.example.myapplication.model;
/*
 *@auther:谷建龙
 *@Date: 2019/11/16
 *@Time:9:04
 *@Description:
 * */


import com.example.myapplication.contacts.Contacts;
import com.example.myapplication.utils.NetUtils;

import java.util.Map;

public class Model implements Contacts.IModel {
    @Override
    public void postInfo(String url, Map<String, String> map, final Contacts.MyCallBack myCallBack) {
        NetUtils.getInstance().doPost(url, map, new NetUtils.MySuccess() {
            @Override
            public void doPost(String json) {
                myCallBack.onSuccess(json);
            }

            @Override
            public void onError(String error) {
                myCallBack.onError(error);
            }
        });
    }
}
