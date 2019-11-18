package com.bawei.gujianlong20191118.presenter;
/*
 *@auther:谷建龙
 *@Date: 2019/11/18
 *@Time:9:21
 *@Description:
 * */


import com.bawei.gujianlong20191118.base.BasePresenter;
import com.bawei.gujianlong20191118.contract.Contract;
import com.bawei.gujianlong20191118.model.Model;

import java.util.Map;

public class Presenter extends BasePresenter {
    private Contract.IModel iModel;

    @Override
    protected void initModel() {
        iModel = new Model();
    }

    @Override
    public void startRequest(String url, Map<String, String> map) {
        iModel.postInfo(url, map, new Contract.MyCallBack() {
            @Override
            public void onMySuccess(String json) {
                getView().onMySuccess(json);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }
}
