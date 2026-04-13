package com.example.simple.core.Exception;

/**
 * 基础异常常量类
 * 定义系统中使用的基础异常代码常量
 */
public final class BaseExceptionConstant {

    private static final long serialVersionUID = 2210579634796378914L;

    /**
     * 未登录
     */
    public static final int NO_LOGIN = 1001;

    /**
     * 无权限
     */
    public static final int NO_AUTHORITY = 1002;

    /**
     * 不存在
     */
    public static final int NOT_EXIST = 1003;

    /**
     * 登录信息不在系统区域
     */
    public static final int login_info_not_sys_area = 1004;

    /**
     * 系统区域错误
     */
    public static final int sys_area_error = 1005;

    /**
     * 参数错误
     */
    public static final int PARAM_ERROR = 1101;

    /**
     * 更新计数错误
     */
    public static final int UPDATE_COUNT_O_ERROR = 1105;

    /**
     * 索引冲突
     */
    public static final int INDEX_CONFLICT = 1106;

    /**
     * 签名错误
     */
    public static final int SIGN_ERROR = 1107;

    /**
     * 业务错误
     */
    public static final int BUSINESS_ERROR = 9999;

    /**
     * 非系统区域
     */
    public static final int NOT_SYS_AREA = 1117;

    /**
     * 未知错误
     */
    public static final int UNYKNOWN_ERROR = 10000;

    /**
     * RPC错误
     */
    public static final int RPC_ERROR = 10001;

    /**
     * API错误
     */
    public static final int API_ERROR = 10002;

    /**
     * 查询信息错误
     */
    public static final int SELECT_INFO_O_ERROR = 10003;

    /**
     * 查询信息多项错误
     */
    public static final int SELECT_INFO_MULTITERM_ERROR = 10004;

    /**
     * 命名空间基础URI错误
     */
    public static final int NAME_SPACE_BASE_URI_ERROR = 10005;

    /**
     * 功能键错误
     */
    public static final int FUNCTION_KEY_ERROR = 10006;

    /**
     * FID不存在
     */
    public static final int FID_NO_EXIST = 10007;

    /**
     * SQL错误
     */
    public static final int SQL_ERROR = 10008;

    /**
     * 中心不存在
     */
    public static final int CENTER_NO_EXIST = 10009;

    /**
     * 中心无结果
     */
    public static final int CENTER_NO_RESULT = 10010;

    /**
     * 定时任务错误
     */
    public static final int TIMETASK_ERROR = 10011;

    /**
     * JSON转换错误
     */
    public static final int JSON_CONVERT_ERROR = 10012;

    /**
     * 反射参数错误
     */
    public static final int REFLECTION_PARAMETER_ERROR = 10013;

    /**
     * 中心API系统区域错误
     */
    public static final int center_api_sys_area_error = 10020;

    /**
     * 协议格式错误
     */
    public static final int PROTO_FORMAT_ERROR = 100014;

    /**
     * DECT转换错误
     */
    public static final int DECT_CONVERT_ERROR = 10015;

    /**
     * 分页处理错误
     */
    public static final int PAGE_PROCESS_ERROR = 10016;

    /**
     * 系统错误
     */
    public static final int SYSTEM_ERROR = 99999;
}
