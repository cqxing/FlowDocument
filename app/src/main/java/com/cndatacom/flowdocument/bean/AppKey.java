package com.cndatacom.flowdocument.bean;

/**
 * Created by staring on 16-11-3.
 */

public class AppKey {
    private String appName;//App名称
    private String appKey;//App接入Key
    private String state;//状态（true启用、false禁用）
    private String createTime;//创建时间（“yyyyMMddHHmmss”）

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
