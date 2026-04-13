package com.example.simple.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 用户实体类
 * 对应数据库表 ssmapi_user
 */
@ApiModel(value = "用户对象", description = "用户信息")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户唯一标识UUID
     */
    @ApiModelProperty(value = "用户UUID", hidden = true)
    private String uuid;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true)
    private String name;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User [uuid=" + uuid + ", name=" + name + ", password=" + password + ", phone=" + phone + ", email="
                + email + ", remark=" + remark + "]";
    }
}
