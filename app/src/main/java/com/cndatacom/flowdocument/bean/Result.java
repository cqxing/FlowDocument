package com.cndatacom.flowdocument.bean;

/**
 * Created by staring on 16-11-3.
 */

public class Result {
    private String result;//状态码00调用正常,其它为异常。
    private String message;//状态码非00时候显示异常信息

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

}
