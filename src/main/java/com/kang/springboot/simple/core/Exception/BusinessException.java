package com.kang.springboot.simple.core.Exception;

public class BusinessException extends RuntimeException
{
  private String errorMsg;
  private ResultCode resultCode;

  public BusinessException(ResultCode resultCode)
  {
    setResultCode(resultCode);
  }

  public BusinessException(ResultCode resultCode, String msg)
  {
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

  public void printLog()
  {
  }
}
