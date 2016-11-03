package com.cndatacom.flowdocument.bean;

/**
 * Created by staring on 16-11-3.
 */

public class OtherLoginResult {
    private String result;//状态码00调用正常,其它为异常。
    private String message;// 状态码非00时候显示异常信息
    private String email;// 邮箱（如为空，需进行绑定邮箱操作-->[1.8]）
    private String name;//昵称
    private String registerTime;//注册时间（“yyyyMMddHHmmss”）
    private String token;// 令牌
    private int passwordState;//（1：初始状态，未设置密码、2：已有密码）


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getPasswordState() {
        return passwordState;
    }

    public void setPasswordState(int passwordState) {
        this.passwordState = passwordState;
    }
}
