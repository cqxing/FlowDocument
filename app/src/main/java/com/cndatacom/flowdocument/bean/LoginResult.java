package com.cndatacom.flowdocument.bean;

/**
 * Created by staring on 16-11-3.
 */

public class LoginResult {

    private String result;//状态码00调用正常,其它为异常。
    private String message;//状态码非00时候显示异常信息
    private String email;//  邮箱
    private String name;//个人：昵称、企业：公司名称
    private String contactMan;//联系人名称（企业）
    private String contactPhone;//联系人手机（企业）
    private String auditState;//审批状态（企业）
    private String auditMsg;////审核意见（企业）
    private String businessLicense;//营业执照图片路径（企业）
    private String registerTime;//注册时间（“yyyyMMddHHmmss”）
    private String token;//令牌

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

    public String getContactMan() {
        return contactMan;
    }

    public void setContactMan(String contactMan) {
        this.contactMan = contactMan;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getAuditState() {
        return auditState;
    }

    public void setAuditState(String auditState) {
        this.auditState = auditState;
    }

    public String getAuditMsg() {
        return auditMsg;
    }

    public void setAuditMsg(String auditMsg) {
        this.auditMsg = auditMsg;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
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
}
