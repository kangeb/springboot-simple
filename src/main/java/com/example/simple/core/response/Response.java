package com.example.simple.core.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 统一响应类
 * 用于封装API接口的返回结果
 */
@ApiModel(value = "统一响应对象", description = "API接口统一返回格式")
public class Response {

    private static final String OK = "ok";
    private static final String ERROR = "error";

    /**
     * 成功状态码
     */
    public static final Integer SUCCESS_CODE = 200;

    /**
     * 错误状态码
     */
    public static final Integer ERROR_CODE = 202;

    /**
     * 元数据
     */
    @ApiModelProperty(value = "响应元数据")
    private Meta meta;

    /**
     * 响应内容
     */
    @ApiModelProperty(value = "响应数据")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    /**
     * 成功响应（无数据）
     *
     * @return Response对象
     */
    public Response success() {
        this.meta = new Meta(true, OK);
        this.meta.code = SUCCESS_CODE;
        return this;
    }

    /**
     * 成功响应（带数据）
     *
     * @param data 响应数据
     * @return Response对象
     */
    public Response success(Object data) {
        this.meta = new Meta(true, OK);
        this.meta.code = SUCCESS_CODE;
        this.data = data;
        return this;
    }

    /**
     * 失败响应（默认消息）
     *
     * @return Response对象
     */
    public Response failure() {
        this.meta = new Meta(false, ERROR);
        this.meta.code = ERROR_CODE;
        return this;
    }

    /**
     * 失败响应（自定义消息）
     *
     * @param message 错误消息
     * @return Response对象
     */
    public Response failure(String message) {
        this.meta = new Meta(false, message);
        this.meta.code = ERROR_CODE;
        return this;
    }

    /**
     * 失败响应（自定义消息和状态码）
     *
     * @param message 错误消息
     * @param code    状态码
     * @return Response对象
     */
    public Response failure(String message, Integer code) {
        this.meta = new Meta(false, message);
        this.meta.code = code;
        return this;
    }

    public Meta getMeta() {
        return meta;
    }

    public Object getData() {
        return data;
    }

    /**
     * 元数据内部类
     * 包含响应的状态信息
     */
    @ApiModel(value = "响应元数据", description = "包含响应状态信息")
    public class Meta {

        /**
         * 是否成功
         */
        @ApiModelProperty(value = "是否成功")
        private boolean success;

        /**
         * 消息
         */
        @ApiModelProperty(value = "响应消息")
        private String message;

        /**
         * 状态码
         */
        @ApiModelProperty(value = "状态码")
        private Integer code;

        public Meta(boolean success) {
            this.success = success;
        }

        public Meta(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }

        public Integer getCode() {
            return code;
        }
    }
}
