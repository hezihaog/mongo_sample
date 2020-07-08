package com.itcast.mongodb.pojo;

import com.itcast.mongodb.http.StatusCode;

/**
 * API结果
 */
public class Result<T> {
    /**
     * 是否成功
     */
    private boolean isOk;
    /**
     * 业务状态码
     */
    private int code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    /**
     * 成功，不返回数据
     */
    public static <T> Result<T> ok() {
        return ok(null);
    }

    /**
     * 成功，不返回数据
     */
    public static <T> Result<T> ok(String msg) {
        return ok(null, msg);
    }

    /**
     * 成功
     *
     * @param data 返回的数据
     */
    public static <T> Result<T> ok(T data) {
        return ok(data, "操作成功");
    }

    /**
     * 成功
     *
     * @param msg  返回的消息
     * @param data 返回的数据
     */
    public static <T> Result<T> ok(T data, String msg) {
        return new Result<T>(StatusCode.OK.getCode(), msg, data);
    }

    /**
     * 失败
     */
    public static <T> Result<T> fail(String msg) {
        return new Result<T>(StatusCode.FAIL.getCode(), msg, null);
    }

    /**
     * 资源不存在
     */
    public static <T> Result<T> notFound() {
        return new Result<T>(StatusCode.NOT_FOUND.getCode(), "数据不存在", null);
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        isOk = code == StatusCode.OK.getCode();
        this.msg = msg;
        this.data = data;
    }

    public Result(boolean isOk, int code, String msg, T data) {
        this.isOk = isOk;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "isOk=" + isOk +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}