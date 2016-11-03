package com.cndatacom.flowdocument.bean;

/**
 * Created by staring on 16-11-3.
 */

public class BuyCertificateResult {

    private String result;//状态码00调用正常,其它为异常。
    private String message;//状态码非00时候显示异常信息
    private String orderId;//订单id
    private int validityTime;//订单有效支付时间（分钟）

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getValidityTime() {
        return validityTime;
    }

    public void setValidityTime(int validityTime) {
        this.validityTime = validityTime;
    }
}
