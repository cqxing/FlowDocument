package com.cndatacom.flowdocument.constant;

/**
 * Created by staring on 16-11-3.
 */

public class ServerConstants {
    public static final String ServerAddress = "http://192.168.200.44:8888/flow_vouch/inter/";

    /*1.用户*/
    //1.2 获取验证码
    public static final String getVerificationCode = ServerAddress + "getVerificationCode";

    //1.3 用户注册（企业）
    public static final String registerCompany = ServerAddress + "registerCompany";

    //1.4 用户注册（个人）
    public static final String registerIndividual = ServerAddress + "registerIndividual";

    //1.5 登陆
    public static final String login = ServerAddress + "login";

    //1.6 个人设置
    public static final String changePassword = ServerAddress + "changePassword";

    //1.7 第三方登陆
    public static final String otherLogin = ServerAddress + "otherLogin";

    //1.8 第三方注册后绑定邮箱
    public static final String otherLoginBinding = ServerAddress + "otherLoginBinding";


    /*2.凭证*/
    //2.2 凭证规格查询
    public static final String certificateList = ServerAddress + "certificateList";
    //2.3 凭证购买
    public static final String buyCertificate = ServerAddress + "buyCertificate";
    //2.4 凭证转赠
    public static final String giveCertificate = ServerAddress + "giveCertificate";
    //2.5 账户余额查询
    public static final String accountBalance = ServerAddress + "accountBalance";
    //2.6 凭证明细查询
    public static final String certificateHistory = ServerAddress + "certificateHistory";
    //2.7 查询赠送目标账户是否有效
    public static final String checkEmail = ServerAddress + "checkEmail";

    /*3 SDK配置（企业）*/
    //3.2 查询AppKey列表（企业）
    public static final String appKeyList = ServerAddress + "appKeyList";
    //3.3 申请AppKey（企业）
    public static final String applyAppKey = ServerAddress + "applyAppKey";

    /*4 通用*/
    //4.1 上传图片
    public static final String uploadImage = ServerAddress + "uploadImage";
}
