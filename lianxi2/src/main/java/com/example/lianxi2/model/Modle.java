package com.example.lianxi2.model;
/*
 *@auther:谷建龙
 *@Date: 2019/11/17
 *@Time:14:59
 *@Description:
 * */


import com.example.lianxi2.contract.Contract;
import com.example.lianxi2.utils.NetUtils;

import java.util.Map;

public class Modle implements Contract.IModel {
    @Override
    public void postInfo(String url, Map<String, String> map, final Contract.MyCallBack myCallBack) {
        NetUtils.getInstance().onPost(url, map, new NetUtils.MySuccess() {
            @Override
            public void onSuccess(String json) {
                myCallBack.onSuccess(json);
            }

            @Override
            public void onError(String error) {
                myCallBack.onError(error);
            }
        });
    }
}
