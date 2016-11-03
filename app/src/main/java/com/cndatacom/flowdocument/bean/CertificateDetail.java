package com.cndatacom.flowdocument.bean;

/**
 * Created by staring on 16-11-3.
 */

public class CertificateDetail {

    private int type;//类型（0=充值、1=消耗、2=转赠、3=被转赠）
    private String giveEmail;//被转赠方账户邮箱
    private int availableTime;//时长（分钟）
    private String fromAppKey;//来自AppKey，充值时;
    private String fromPublicIp;//公网IP
    private String fromIp;//私网IP

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getGiveEmail() {
        return giveEmail;
    }

    public void setGiveEmail(String giveEmail) {
        this.giveEmail = giveEmail;
    }

    public int getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(int availableTime) {
        this.availableTime = availableTime;
    }

    public String getFromAppKey() {
        return fromAppKey;
    }

    public void setFromAppKey(String fromAppKey) {
        this.fromAppKey = fromAppKey;
    }

    public String getFromPublicIp() {
        return fromPublicIp;
    }

    public void setFromPublicIp(String fromPublicIp) {
        this.fromPublicIp = fromPublicIp;
    }

    public String getFromIp() {
        return fromIp;
    }

    public void setFromIp(String fromIp) {
        this.fromIp = fromIp;
    }
}
