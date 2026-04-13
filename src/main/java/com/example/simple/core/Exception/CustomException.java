package com.example.simple.core.Exception;

/**
 * 自定义异常类
 * 用于封装业务逻辑中的自定义错误信息
 */
public final class CustomException extends RuntimeException {

    private static final long serialVersionUID = 4184239072785931969L;

    /**
     * 错误码
     */
    private int code;

    /**
     * 错误消息
     */
    private String msg;

    /**
     * 请求URI
     */
    private String uri = null;

    /**
     * 构造方法（仅错误码）
     *
     * @param code 错误码
     */
    public CustomException(int code) {
        this.code = code;
    }

    /**
     * 构造方法（仅错误消息）
     *
     * @param message 错误消息
     */
    public CustomException(String message) {
        super(message);
        this.code = 9999;
        this.msg = message;
    }

    /**
     * 构造方法（错误码和错误消息）
     *
     * @param code    错误码
     * @param message 错误消息
     */
    public CustomException(int code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    /**
     * 构造方法（错误码和异常原因）
     *
     * @param code  错误码
     * @param cause 异常原因
     */
    public CustomException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    /**
     * 构造方法（错误消息和异常原因）
     *
     * @param message 错误消息
     * @param cause   异常原因
     */
    public CustomException(String message, Throwable cause) {
        super(message, cause);
        this.code = 9999;
        this.msg = message;
    }

    /**
     * 构造方法（错误码、错误消息和异常原因）
     *
     * @param code    错误码
     * @param message 错误消息
     * @param cause   异常原因
     */
    public CustomException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.msg = message;
    }

    /**
     * 构造方法（错误码、URI和错误消息）
     *
     * @param code    错误码
     * @param uri     请求URI
     * @param message 错误消息
     */
    public CustomException(int code, String uri, String message) {
        super(message);
        this.code = code;
        this.msg = message;
        this.uri = uri;
    }

    /**
     * 构造方法（错误码、URI、错误消息和异常原因）
     *
     * @param code    错误码
     * @param uri     请求URI
     * @param message 错误消息
     * @param cause   异常原因
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
