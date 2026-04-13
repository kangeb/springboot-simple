package com.example.simple.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "用户实体类")
public class User implements Serializable {

	@ApiModelProperty(value = "用户唯一标识UUID")
	private String uuid;

	@ApiModelProperty(value = "用户名", required = true)
	private String name;

	@ApiModelProperty(value = "密码", required = true)
	private String password;

	@ApiModelProperty(value = "手机号")
	private String phone;

	@ApiModelProperty(value = "邮箱")
	private String email;

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
