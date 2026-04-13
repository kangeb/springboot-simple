package com.example.simple.domain;

import java.io.Serializable;

/**
 * 用户实体类
 * 对应数据库表ssmapi_user
 */
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /** 用户唯一标识 */
    private String uuid;
    /** 用户名 */
    private String name;
    /** 密码 */
    private String password;
    /** 手机号 */
    private String phone;
    /** 邮箱 */
    private String email;
    /** 备注 */
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
