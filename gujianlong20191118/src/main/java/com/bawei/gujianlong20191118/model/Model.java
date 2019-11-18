package com.bawei.gujianlong20191118.model;
/*
 *@auther:谷建龙
 *@Date: 2019/11/18
 *@Time:9:12
 *@Description:
 * */


import com.bawei.gujianlong20191118.contract.Contract;
import com.bawei.gujianlong20191118.utils.NetUtils;

import java.util.Map;

public class Model implements Contract.IModel {
    @Override
    public void postInfo(String url, Map<String, String> map, final Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().onPost(url, map, new NetUtils.MySuccess() {
            @Override
            public void onSuccess(String json) {
                myCallBack.onMySuccess(json);
            }

            @Override
            public void onError(String error) {
                myCallBack.onError(error);
            }
        });
    }
}
