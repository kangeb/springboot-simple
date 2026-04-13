package com.example.simple.core.Exception;

/**
 * 结果码枚举
 * 定义系统中使用的各种结果码
 */
public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    /**
     * 数据库错误
     */
    DB_ERR(1000, "数据库错误"),

    /**
     * 参数错误
     */
    PARAM_ERR(1001, "参数错误"),

    /**
     * 网络错误
     */
    NET_ERR(1002, "网络错误"),

    /**
     * 系统内部错误
     */
    INNER_ERR(1003, "系统内部错误"),

    /**
     * key已列入黑名单
     */
    BLACK_KEY(1004, "key已列入黑名单"),

    /**
     * 解密失败
     */
    DECRY_FAIL(1005, "解密失败,key可能遭到篡改"),

    /**
     * key数据格式错误
     */
    DATA_ERR(1006, "key数据格式错误"),

    /**
     * 时间戳无效
     */
    TIME_INVALID(1007, "时间戳无效"),

    /**
     * 验证码已过期
     */
    CODE_OUTDATE(1008, "验证码已过期"),

    /**
     * 验证码已被验证
     */
    CODE_VERIFIED(1009, "该验证码已经被验证过");

    /**
     * 结果码
     */
    private int resultCode;

    /**
     * 结果描述
     */
    private String resultDes;

    ResultCode(int resultCode, String resultDes) {
        setResultCode(resultCode);
        setResultDes(resultDes);
    }

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
