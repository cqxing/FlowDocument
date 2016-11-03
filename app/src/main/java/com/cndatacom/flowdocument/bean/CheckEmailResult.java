package com.cndatacom.flowdocument.bean;

/**
 * Created by staring on 16-11-3.
 */

public class CheckEmailResult {

    private String result;//状态码00调用正常,其它为异常。
    private String message;//状态码非00时候显示异常信息
    private Boolean state;//（True=有效、False=无效）

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

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
