package com.cndatacom.flowdocument.bean;

/**
 * Created by staring on 16-11-3.
 */
/*凭证*/
public class Certificate {

    private String certificateId;//凭证id
    private String name;// 凭证名称
    private String describe;// 凭证描述
    private int price;// 凭证价格
    private int availableTime;//凭证包含时长
    private String logo;//Logo图片地址

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(int availableTime) {
        this.availableTime = availableTime;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
