package com.example.simple.core.Exception;

/**
 * 自定义异常类
 * 用于业务逻辑中抛出自定义异常
 */
public final class CustomException extends RuntimeException {

    private static final long serialVersionUID = 4184239072785931969L;

    /** 错误码 */
    private int code;

    /** 错误消息 */
    private String msg;

    /** 请求URI */
    private String uri = null;

    /**
     * 根据错误码构造异常
     * @param code 错误码
     */
    public CustomException(int code) {
        this.code = code;
    }

    /**
     * 根据消息构造异常
     * @param message 错误消息
     */
    public CustomException(String message) {
        super(message);
        this.code = 9999;
        this.msg = message;
    }

    /**
     * 根据错误码和消息构造异常
     * @param code 错误码
     * @param message 错误消息
     */
    public CustomException(int code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    /**
     * 根据错误码和原因构造异常
     * @param code 错误码
     * @param cause 异常原因
     */
    public CustomException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    /**
     * 根据消息和原因构造异常
     * @param message 错误消息
     * @param cause 异常原因
     */
    public CustomException(String message, Throwable cause) {
        super(message, cause);
        this.code = 9999;
        this.msg = message;
    }

    /**
     * 根据错误码、消息和原因构造异常
     * @param code 错误码
     * @param message 错误消息
     * @param cause 异常原因
     */
    public CustomException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.msg = message;
    }

    /**
     * 根据错误码、URI和消息构造异常
     * @param code 错误码
     * @param uri 请求URI
     * @param message 错误消息
     */
    public CustomException(int code, String uri, String message) {
        super(message);
        this.code = code;
        this.msg = message;
        this.uri = uri;
    }

    /**
     * 根据错误码、URI、消息和原因构造异常
     * @param code 错误码
     * @param uri 请求URI
     * @param message 错误消息
     * @param cause 异常原因
     */
    public CustomException(int code, String uri, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.msg = message;
        this.uri = uri;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
