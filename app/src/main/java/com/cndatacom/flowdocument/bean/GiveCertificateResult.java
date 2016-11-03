package com.cndatacom.flowdocument.bean;

/**
 * Created by staring on 16-11-3.
 */

public class GiveCertificateResult {
    private String result;//状态码00调用正常,其它为异常。
    private String message;//状态码非00时候显示异常信息
    private int accountBalance;//本账户剩余时长

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

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }
}
