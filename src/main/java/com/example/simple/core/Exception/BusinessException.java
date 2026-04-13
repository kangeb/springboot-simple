package com.example.simple.core.Exception;

/**
 * 业务异常类
 * 用于业务逻辑中抛出带有结果码的异常
 */
public class BusinessException extends RuntimeException {

    /** 错误消息 */
    private String errorMsg;

    /** 结果码 */
    private ResultCode resultCode;

    /**
     * 根据结果码构造异常
     * @param resultCode 结果码
     */
    public BusinessException(ResultCode resultCode) {
        setResultCode(resultCode);
    }

    /**
     * 根据结果码和消息构造异常
     * @param resultCode 结果码
     * @param msg 错误消息
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
     * 打印日志
     */
    public void printLog() {
    }
}
