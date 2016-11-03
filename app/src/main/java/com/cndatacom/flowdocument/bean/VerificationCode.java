package com.cndatacom.flowdocument.bean;

/**
 * Created by staring on 16-11-3.
 */

public class VerificationCode {

    /*{"message":"调用成功","result":"00","validityTime":5,"verificationCode":"66608L"}*/
    private String result;//状态码00调用正常,其它为异常。
    private String message;//状态码非00时候显示异常信息
    private String verificationCode;//验证码有效时间
    private int validityTime;//验证码有效时间（分钟）

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

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public int getValidityTime() {
        return validityTime;
    }

    public void setValidityTime(int validityTime) {
        this.validityTime = validityTime;
    }

    @Override
    public String toString() {
        return "result:" + result + "," + "message:" + message + ","
                + "verificationCode:" + verificationCode + "," + "validityTime:" + validityTime;
    }
}
