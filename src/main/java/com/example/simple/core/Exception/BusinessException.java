package com.example.simple.core.Exception;

/**
 * 业务异常类
 * 用于封装业务逻辑中的错误信息
 */
public class BusinessException extends RuntimeException {

    /**
     * 错误消息
     */
    private String errorMsg;

    /**
     * 结果码枚举
     */
    private ResultCode resultCode;

    /**
     * 构造方法（仅结果码）
     *
     * @param resultCode 结果码枚举
     */
    public BusinessException(ResultCode resultCode) {
        setResultCode(resultCode);
    }

    /**
     * 构造方法（结果码和错误消息）
     *
     * @param resultCode 结果码枚举
     * @param msg        错误消息
     */
    public BusinessException(ResultCode resultCode, String msg) {
        this.errorMsg = msg;
        setResultCode(resultCode);
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ResultCode getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * 打印日志（预留方法）
     */
    public void printLog() {
    }
}
