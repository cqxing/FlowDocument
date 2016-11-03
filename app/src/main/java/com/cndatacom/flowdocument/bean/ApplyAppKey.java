package com.cndatacom.flowdocument.bean;

/**
 * Created by staring on 16-11-3.
 */

public class ApplyAppKey {

    private String result;//状态码00调用正常,其它为异常。
    private String message;//状态码非00时候显示异常信息
    private String appKey;//App接入Key

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

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
}
