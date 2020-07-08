package com.itcast.mongodb.http;

/**
 * 状态码
 */
public enum StatusCode {
    /**
     * 成功
     */
    OK(200),
    /**
     * 失败
     */
    FAIL(500),
    /**
     * 找不到
     */
    NOT_FOUND(404);

    private final int code;

    StatusCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}