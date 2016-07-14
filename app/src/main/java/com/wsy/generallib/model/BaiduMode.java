package com.wsy.generallib.model;

/**
 * Created by wsy on 16/7/14.
 */
public class BaiduMode extends BaseMessage{

    @Override
    public String getRuqestURL() {
        return "http://www.baidu.com";
    }

    private String value1;
    private String value2;

    public BaiduMode(String value1, String value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public BaiduMode() {
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }
}
