package com.example.myapplication.contacts;
/*
 *@auther:谷建龙
 *@Date: 2019/11/16
 *@Time:8:56
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
        void startRequest(String url, Map<String, String> map);
    }
}
