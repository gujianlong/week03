package com.bawei.gujianlong20191118.utils;
/*
 *@auther:谷建龙
 *@Date: 2019/11/18
 *@Time:8:58
 *@Description:
 * */


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.RelativeLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.gujianlong20191118.app.MyApp;

import java.util.Map;

public class NetUtils {
    //基类
    private final RequestQueue requestQueue;
    private ConnectivityManager connectivityManager;

    private NetUtils() {
        requestQueue = Volley.newRequestQueue(MyApp.mContext);
    }

    private static class net {
        private static NetUtils netUtils = new NetUtils();
    }

    public static NetUtils getInstance() {
        return net.netUtils;
    }

    public interface MySuccess {
        void onSuccess(String json);

        void onError(String error);
    }

    //⑤　封装Volley的get和post。
    public void onPost(String url, final Map<String, String> map, final MySuccess mySuccess) {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mySuccess.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mySuccess.onError(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (map != null) {
                    return map;
                }
                return super.getParams();
            }
        };
        requestQueue.add(request);
    }

    //⑤　封装Volley的get和post。
    public void onGet(String url, final MySuccess mySuccess) {
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mySuccess.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mySuccess.onError(error.getMessage());
            }
        });
        requestQueue.add(request);
    }

    // ⑥　封装网络状态判断方法，可以判断有网无网。
    public boolean hasNet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            return true;
        } else {
            return false;
        }
    }
}
