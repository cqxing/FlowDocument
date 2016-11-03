package com.cndatacom.flowdocument.constant;

/**
 * Created by staring on 16-11-3.
 */

public class ResultCode {
    public static final String success_code = "00";
    public static final String fail_code_error_params = "01";
    public static final String fail_code_error_encryption = "02";
    public static final String fail_code_error_timestamp = "03";
    public static final String fail_code_error_token = "04";
    public static final String fail_code_error_verification_code = "05";
    public static final String fail_code_error_exits = "06";
    public static final String fail_code_error_server_busy = "07";
    public static final String fail = "08";


    public static final String message_success = "调用成功";
    public static final String message_fail_params = "缺少必要参数或参数错误";
    public static final String message_fail_encryption = "加密串校验失败";
    public static final String message_fail_timestamp = "时间戳格式错误";
    public static final String message_fail_token = "令牌失效或令牌错误";
    public static final String message_fail_verification_code = "验证码校验失败";
    public static final String message_fail_exits= "记录已存在";
    public static final String message_fail_server_busy = "服务器繁忙";
    public static final String message_fail = "调用失败,失败原因在message里";

}
