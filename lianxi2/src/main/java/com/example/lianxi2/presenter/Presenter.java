package com.example.lianxi2.presenter;
/*
 *@auther:谷建龙
 *@Date: 2019/11/17
 *@Time:15:18
 *@Description:
 * */


import com.example.lianxi2.R;
import com.example.lianxi2.base.BasePresenter;
import com.example.lianxi2.contract.Contract;
import com.example.lianxi2.model.Modle;
import com.example.lianxi2.utils.NetUtils;

import java.util.Map;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;

    @Override
    protected void initModel() {
        iModel = new Modle();
    }

    @Override
    public void startRequest(String url, Map<String, String> map) {
        iModel.postInfo(url, map, new Contract.MyCallBack() {
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
