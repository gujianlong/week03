package com.example.myapplication.presenter;
/*
 *@auther:谷建龙
 *@Date: 2019/11/16
 *@Time:9:32
 *@Description:
 * */


import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.contacts.Contacts;
import com.example.myapplication.model.Model;

import java.util.Map;

public class Presenter extends BasePresenter {
    private Contacts.IModel iModel;

    @Override
    protected void initModel() {
        iModel = new Model();
    }

    @Override
    public void startRequest(String url, Map<String, String> map) {
        iModel.postInfo(url, map, new Contacts.MyCallBack() {
            @Override
            public void onSuccess(String json) {
                getView().onSuccess(json);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }
}
