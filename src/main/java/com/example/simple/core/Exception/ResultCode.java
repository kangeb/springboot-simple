package com.example.simple.core.Exception;

public enum ResultCode
{
  SUCCESS(0, "成功"), DB_ERR(1000, "数据库错误"), PARAM_ERR(1001, "参数错误"), NET_ERR(1002, "网络错误"), INNER_ERR(1003, "系统内部错误"), 
  BLACK_KEY(1004, "key已列入黑名单"), DECRY_FAIL(1005, "解密失败,key可能遭到篡改"), DATA_ERR(1006, "key数据格式错误"), TIME_INVALID(1007, "时间戳无效"), CODE_OUTDATE(1008, "验证码已过期"), 
  CODE_VERIFIED(1009, "该验证码已经被验证过");

  private int resultCode;
  private String resultDes;

  private ResultCode(int resultCode, String resultDes) { setResultCode(resultCode);
    setResultDes(resultDes); }

  public int getResultCode() {
    return this.resultCode;
  }
  public void setResultCode(int resultCode) {
    this.resultCode = resultCode;
  }
  public String getResultDes() {
    return this.resultDes;
  }
  public void setResultDes(String resultDes) {
    this.resultDes = resultDes;
  }
}
