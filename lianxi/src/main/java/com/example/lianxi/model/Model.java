package com.example.lianxi.model;
/*
 *@auther:谷建龙
 *@Date: 2019/11/16
 *@Time:17:18
 *@Description:
 * */


import com.example.lianxi.contacts.Contacts;
import com.example.lianxi.utils.NetUtils;

import java.util.Map;

public class Model implements Contacts.IModel {
    @Override
    public void postInfo(String url, Map<String, String> map, final Contacts.MyCallBack myCallBack) {
        NetUtils.getInstance().doPost(url, map, new NetUtils.MySuccess() {
            @Override
            public void onDoPost(String json) {
                myCallBack.onSuccess(json);
            }

            @Override
            public void onError(String error) {
                myCallBack.onError(error);
            }
        });
    }
}
