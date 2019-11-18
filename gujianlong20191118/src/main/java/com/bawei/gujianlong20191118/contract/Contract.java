package com.bawei.gujianlong20191118.contract;
/*
 *@auther:谷建龙
 *@Date: 2019/11/18
 *@Time:9:08
 *@Description:
 * */


import com.android.volley.toolbox.Volley;
import com.bawei.gujianlong20191118.utils.NetUtils;

import java.util.Map;

public interface Contract {
    interface MyCallBack {
        void onMySuccess(String json);

        void onError(String error);
    }

    interface IModel {
        void postInfo(String url, Map<String, String> map, MyCallBack myCallBack);
    }

    interface IView {
        void onMySuccess(String json);

        void onError(String error);
    }

    interface IPresenter {
        void startRequest(String url, Map<String, String> map);
    }
}
