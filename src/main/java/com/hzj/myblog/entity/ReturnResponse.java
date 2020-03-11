package com.hzj.myblog.entity;

/**
 * 返回结果的实体
 *
 * @author 何志坚
 */
public class ReturnResponse<T> {
    /**
     * 返回的状态码
     */
    private Integer code;
    /**
     * 返回的消息
     */
    private String message;
    /**
     * 返回的数据
     */
    private T data;

    public ReturnResponse() {
    }

    public ReturnResponse(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ReturnResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ReturnResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ReturnModel{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
