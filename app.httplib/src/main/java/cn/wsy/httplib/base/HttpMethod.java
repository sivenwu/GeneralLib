package cn.wsy.httplib.base;

/**
 * 请求方式
 * Created by wsy on 16/7/14.
 */
public enum HttpMethod {

    GET("GET"),
    POST("POST");

    private final String value;

    private HttpMethod(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }

}
