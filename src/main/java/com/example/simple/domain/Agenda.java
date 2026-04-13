package com.example.simple.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "日程实体类")
public class Agenda implements Serializable {

	@ApiModelProperty(value = "当前页码")
	private String currentPage;

	@ApiModelProperty(value = "每页条数")
	private String pageSize;

	@ApiModelProperty(value = "日程唯一标识UUID")
	private String uuid;

	@ApiModelProperty(value = "日程标题", required = true)
	private String title;

	@ApiModelProperty(value = "日程详情内容")
	private String details;

	@ApiModelProperty(value = "日程日期")
	private String date;

	@ApiModelProperty(value = "日程创建人名称")
	private String name;

	@ApiModelProperty(value = "备注")
	private String remark;

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Agenda [currentPage=" + currentPage + ", pageSize=" + pageSize + ", uuid=" + uuid + ", title=" + title
				+ ", details=" + details + ", date=" + date + ", name=" + name + ", remark=" + remark + "]";
	}
}
