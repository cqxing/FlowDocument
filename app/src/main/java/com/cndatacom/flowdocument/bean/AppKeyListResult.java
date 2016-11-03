package com.cndatacom.flowdocument.bean;

import java.util.ArrayList;

/**
 * Created by staring on 16-11-3.
 */

public class AppKeyListResult {
    private String result;//状态码00调用正常,其它为异常。
    private String message;//状态码非00时候显示异常信息
    private ArrayList<AppKey> data;//AppKey列表

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<AppKey> getData() {
        return data;
    }

    public void setData(ArrayList<AppKey> data) {
        this.data = data;
    }
}
