package com.glory.entity;

import java.io.PrintWriter;

/**
 * Created by Monster on 2017/11/18.
 */
public class ResponseJson {

    private int code;

    private Object data;

    private String msg;

    public int getCode() {
        return code;
    }

    public ResponseJson(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
