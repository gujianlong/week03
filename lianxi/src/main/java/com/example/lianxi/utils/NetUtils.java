package com.example.lianxi.utils;
/*
 *@auther:谷建龙
 *@Date: 2019/11/16
 *@Time:11:27
 *@Description:
 * */


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lianxi.app.MyApp;

import java.util.Map;

public class NetUtils {

    private final RequestQueue requestQueue;

    public NetUtils() {
        requestQueue = Volley.newRequestQueue(MyApp.mContext);
    }

    private static class net {
        private static NetUtils netUtils = new NetUtils();
    }

    public static NetUtils getInstance() {
        return net.netUtils;
    }

    public interface MySuccess {
        void onDoPost(String json);

        void onError(String error);
    }

    public void doPost(String url, final Map<String, String> map, final MySuccess mySuccess) {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mySuccess.onDoPost(response);
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


}
