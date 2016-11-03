package com.cndatacom.flowdocument.utils;

import android.text.TextUtils;

import com.cndatacom.flowdocument.constant.AppConstants;
import com.cndatacom.flowdocument.constant.ServerConstants;

import org.xutils.common.util.MD5;
import org.xutils.http.RequestParams;

import java.io.File;
import java.util.Date;

/**
 * Created by staring on 16-11-3.
 */

public class RequestParamsHelper {

    /*1.用户*/
    //1.2 获取验证码
    //public static final String getVerificationCode = ServerAddress + "getVerificationCode";
    public static RequestParams getVerificationCodeParams(String email, String openid, int type) {
        RequestParams requestParams = new RequestParams(ServerConstants.getVerificationCode);
        requestParams.addBodyParameter("email", email);
        if (TextUtils.isEmpty(openid)) {
            requestParams.addBodyParameter("openid", openid);
        }
        requestParams.addBodyParameter("type", String.valueOf(type));
        String timestamp = DateUtils.nowTime(new Date());
        requestParams.addBodyParameter("timestamp", timestamp);
        requestParams.addBodyParameter("key", MD5.md5(AppConstants.secret_key + timestamp));
        return requestParams;
    }

    //1.3 用户注册（企业）
    //public static final String registerCompany = ServerAddress + "registerCompany";
    public static RequestParams registerCompanyParams(String email, String password, String name,
                                                      String contactMan, String contactPhone, String businessLicense,
                                                      String verificationCode) {
        RequestParams requestParams = new RequestParams(ServerConstants.registerCompany);
        requestParams.addBodyParameter("email", email);
        requestParams.addBodyParameter("password", MD5.md5(password));
        requestParams.addBodyParameter("name", name);
        requestParams.addBodyParameter("contactMan", contactMan);
        requestParams.addBodyParameter("contactPhone", contactPhone);
        requestParams.addBodyParameter("businessLicense", businessLicense);
        requestParams.addBodyParameter("verificationCode", verificationCode);
        String timestamp = DateUtils.nowTime(new Date());
        requestParams.addBodyParameter("timestamp", timestamp);
        requestParams.addBodyParameter("key", MD5.md5(AppConstants.secret_key + timestamp));
        return requestParams;
    }

    //1.4 用户注册（个人）
    //public static final String registerIndividual = ServerAddress + "registerIndividual";
    public static RequestParams registerIndividualParams(String email, String password, String name,
                                                         String verificationCode) {
        RequestParams requestParams = new RequestParams(ServerConstants.registerIndividual);
        requestParams.addBodyParameter("email", email);
        requestParams.addBodyParameter("password", MD5.md5(password));
        requestParams.addBodyParameter("name", name);
        requestParams.addBodyParameter("verificationCode", verificationCode);
        String timestamp = DateUtils.nowTime(new Date());
        requestParams.addBodyParameter("timestamp", timestamp);
        requestParams.addBodyParameter("key", MD5.md5(AppConstants.secret_key + timestamp));
        return requestParams;
    }

    //1.5 登陆
    //public static final String login = ServerAddress + "login";
    public static RequestParams loginParams(String email, String password) {
        RequestParams requestParams = new RequestParams(ServerConstants.login);
        requestParams.addBodyParameter("email", email);
        requestParams.addBodyParameter("password", MD5.md5(password));
        String timestamp = DateUtils.nowTime(new Date());
        requestParams.addBodyParameter("timestamp", timestamp);
        requestParams.addBodyParameter("key", MD5.md5(AppConstants.secret_key + timestamp));
        return requestParams;
    }

    //1.6 个人设置
    //public static final String changePassword = ServerAddress + "changePassword";
    public static RequestParams changePasswordParams(String token, String password, String oldPassword) {
        RequestParams requestParams = new RequestParams(ServerConstants.changePassword);
        requestParams.addBodyParameter("token", token);
        requestParams.addBodyParameter("password", MD5.md5(password));
        requestParams.addBodyParameter("oldPassword", MD5.md5(oldPassword));
        String timestamp = DateUtils.nowTime(new Date());
        requestParams.addBodyParameter("timestamp", timestamp);
        requestParams.addBodyParameter("key", MD5.md5(AppConstants.secret_key + timestamp));
        return requestParams;
    }

    //1.7 第三方登陆
    //public static final String otherLogin = ServerAddress + "otherLogin";
    public static RequestParams otherLoginParams(String type, String openid, String name) {
        RequestParams requestParams = new RequestParams(ServerConstants.otherLogin);
        requestParams.addBodyParameter("type", type);
        requestParams.addBodyParameter("openid", openid);
        requestParams.addBodyParameter("name", name);
        String timestamp = DateUtils.nowTime(new Date());
        requestParams.addBodyParameter("timestamp", timestamp);
        requestParams.addBodyParameter("key", MD5.md5(AppConstants.secret_key + timestamp));
        return requestParams;
    }

    //1.8 第三方注册后绑定邮箱
    //public static final String otherLoginBinding = ServerAddress + "otherLoginBinding";
    public static RequestParams otherLoginBindingParams(String type, String openid, String email, String password, String verificationCode) {
        RequestParams requestParams = new RequestParams(ServerConstants.otherLoginBinding);
        requestParams.addBodyParameter("type", type);
        requestParams.addBodyParameter("openid", openid);
        requestParams.addBodyParameter("email", email);
        requestParams.addBodyParameter("password", MD5.md5(password));
        requestParams.addBodyParameter("verificationCode", verificationCode);
        String timestamp = DateUtils.nowTime(new Date());
        requestParams.addBodyParameter("timestamp", timestamp);
        requestParams.addBodyParameter("key", MD5.md5(AppConstants.secret_key + timestamp));
        return requestParams;
    }

    /*2.凭证*/
    //2.2 凭证规格查询
    //public static final String certificateList = ServerAddress + "certificateList";
    public static RequestParams certificateListParams(String token, int pageNum, int pageSize) {
        RequestParams requestParams = new RequestParams(ServerConstants.certificateList);
        requestParams.addBodyParameter("token", token);
        requestParams.addBodyParameter("pageNum", String.valueOf(pageNum));
        requestParams.addBodyParameter("pageSize", String.valueOf(pageSize));
        String timestamp = DateUtils.nowTime(new Date());
        requestParams.addBodyParameter("timestamp", timestamp);
        requestParams.addBodyParameter("key", MD5.md5(AppConstants.secret_key + timestamp));
        return requestParams;
    }

    //2.3 凭证购买
    //public static final String buyCertificate = ServerAddress + "buyCertificate";
    public static RequestParams buyCertificateParams(String token, String certificateId) {
        RequestParams requestParams = new RequestParams(ServerConstants.buyCertificate);
        requestParams.addBodyParameter("token", token);
        requestParams.addBodyParameter("certificateId", certificateId);
        String timestamp = DateUtils.nowTime(new Date());
        requestParams.addBodyParameter("timestamp", timestamp);
        requestParams.addBodyParameter("key", MD5.md5(AppConstants.secret_key + timestamp));
        return requestParams;
    }

    //2.4 凭证转赠
    //public static final String giveCertificate = ServerAddress + "giveCertificate";
    public static RequestParams giveCertificateParams(String token, String giveEmail, String val, String verificationCode) {
        RequestParams requestParams = new RequestParams(ServerConstants.giveCertificate);
        requestParams.addBodyParameter("token", token);
        requestParams.addBodyParameter("giveEmail", giveEmail);
        requestParams.addBodyParameter("val", val);
        requestParams.addBodyParameter("verificationCode", verificationCode);
        String timestamp = DateUtils.nowTime(new Date());
        requestParams.addBodyParameter("timestamp", timestamp);
        requestParams.addBodyParameter("key", MD5.md5(AppConstants.secret_key + timestamp));
        return requestParams;
    }

    //2.5 账户余额查询
    //public static final String accountBalance = ServerAddress + "accountBalance";
    public static RequestParams accountBalanceParams(String token) {
        RequestParams requestParams = new RequestParams(ServerConstants.accountBalance);
        requestParams.addBodyParameter("token", token);
        String timestamp = DateUtils.nowTime(new Date());
        requestParams.addBodyParameter("timestamp", timestamp);
        requestParams.addBodyParameter("key", MD5.md5(AppConstants.secret_key + timestamp));
        return requestParams;
    }

    //2.6 凭证明细查询
    //public static final String certificateHistory = ServerAddress + "certificateHistory";
    public static RequestParams certificateHistoryParams(String token, String type, int pageNum, int pageSize) {
        RequestParams requestParams = new RequestParams(ServerConstants.certificateHistory);
        requestParams.addBodyParameter("token", token);
        requestParams.addBodyParameter("type", type);
        requestParams.addBodyParameter("pageNum", String.valueOf(pageNum));
        requestParams.addBodyParameter("pageSize", String.valueOf(pageSize));
        String timestamp = DateUtils.nowTime(new Date());
        requestParams.addBodyParameter("timestamp", timestamp);
        requestParams.addBodyParameter("key", MD5.md5(AppConstants.secret_key + timestamp));
        return requestParams;
    }


    //2.7 查询赠送目标账户是否有效
    //public static final String checkEmail = ServerAddress + "checkEmail";
    public static RequestParams checkEmailParams(String token, String email) {
        RequestParams requestParams = new RequestParams(ServerConstants.checkEmail);
        requestParams.addBodyParameter("token", token);
        String timestamp = DateUtils.nowTime(new Date());
        requestParams.addBodyParameter("timestamp", timestamp);
        requestParams.addBodyParameter("key", MD5.md5(AppConstants.secret_key + timestamp));
        return requestParams;
    }

    /*3 SDK配置（企业）*/
    //3.2 查询AppKey列表（企业）
    //public static final String appKeyList = ServerAddress + "appKeyList";
    public static RequestParams appKeyListParams(String token) {
        RequestParams requestParams = new RequestParams(ServerConstants.appKeyList);
        requestParams.addBodyParameter("token", token);
        String timestamp = DateUtils.nowTime(new Date());
        requestParams.addBodyParameter("timestamp", timestamp);
        requestParams.addBodyParameter("key", MD5.md5(AppConstants.secret_key + timestamp));
        return requestParams;
    }

    //3.3 申请AppKey（企业）
    //public static final String applyAppKey = ServerAddress + "applyAppKey";
    public static RequestParams applyAppKeyParams(String token, String appName, String verificationCode) {
        RequestParams requestParams = new RequestParams(ServerConstants.applyAppKey);
        requestParams.addBodyParameter("token", token);
        requestParams.addBodyParameter("appName", appName);
        requestParams.addBodyParameter("verificationCode", verificationCode);
        String timestamp = DateUtils.nowTime(new Date());
        requestParams.addBodyParameter("timestamp", timestamp);
        requestParams.addBodyParameter("key", MD5.md5(AppConstants.secret_key + timestamp));
        return requestParams;
    }

    /*4 通用*/
    //4.1 上传图片
    //public static final String uploadImage = ServerAddress + "uploadImage";
    public static RequestParams uploadImageParams(File file) {
        RequestParams requestParams = new RequestParams(ServerConstants.uploadImage);
        requestParams.addBodyParameter("file", file);
        String timestamp = DateUtils.nowTime(new Date());
        requestParams.addBodyParameter("timestamp", timestamp);
        requestParams.addBodyParameter("key", MD5.md5(AppConstants.secret_key + timestamp));
        return requestParams;
    }
}
