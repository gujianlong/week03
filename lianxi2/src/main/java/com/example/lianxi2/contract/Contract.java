package com.example.lianxi2.contract;
/*
 *@auther:谷建龙
 *@Date: 2019/11/17
 *@Time:14:53
 *@Description:
 * */


import java.sql.SQLTransactionRollbackException;
import java.util.Map;

public interface Contract {
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
