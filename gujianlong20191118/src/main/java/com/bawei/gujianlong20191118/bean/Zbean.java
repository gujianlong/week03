package com.bawei.gujianlong20191118.bean;
/*
 *@auther:谷建龙
 *@Date: 2019/11/18
 *@Time:9:24
 *@Description:
 * */


public class Zbean {
    /**
     * message : 该手机号已注册，不能重复注册！
     * status : 1001
     */

    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
