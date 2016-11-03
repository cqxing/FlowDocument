package com.cndatacom.flowdocument.bean;

import java.util.ArrayList;

/**
 * Created by staring on 16-11-3.
 */

public class CertificateResult {

    private String result;//状态码00调用正常,其它为异常。
    private String message;//状态码非00时候显示异常信息
    private int pageNum;//页码
    private int pageSize;//条数
    private int count;//总记录数
    private ArrayList<Certificate> data;//凭证列表

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

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Certificate> getData() {
        return data;
    }

    public void setData(ArrayList<Certificate> data) {
        this.data = data;
    }
}
