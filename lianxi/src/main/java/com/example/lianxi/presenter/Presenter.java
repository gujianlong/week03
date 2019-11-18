package com.example.lianxi.presenter;
/*
 *@auther:谷建龙
 *@Date: 2019/11/16
 *@Time:17:31
 *@Description:
 * */


import com.example.lianxi.base.BasePresenter;
import com.example.lianxi.contacts.Contacts;
import com.example.lianxi.model.Model;

import java.util.Map;

public class Presenter extends BasePresenter {
    private Contacts.IModel iModel;

    @Override
    protected void initModel() {
        iModel = new Model();
    }

    @Override
    public void startRequest(String json, Map<String, String> map) {
        iModel.postInfo(json, map, new Contacts.MyCallBack() {
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
