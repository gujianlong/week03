package com.example.lianxi.contacts;
/*
 *@auther:谷建龙
 *@Date: 2019/11/16
 *@Time:11:27
 *@Description:
 * */


import java.util.Map;

public interface Contacts {
    interface MyCallBack {
        void onSuccess(String json);

        void onError(String error);
    }

    interface IModel {
        void postInfo(String url, Map<String, String> map, MyCallBack myCallBack);
    }

    interface IView {
        void onSuccess(String json);

        void onError(String error);
    }

    interface IPresenter {
        void startRequest(String json, Map<String, String> map);
    }
}
