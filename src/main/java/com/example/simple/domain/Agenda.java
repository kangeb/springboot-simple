package com.example.simple.domain;

import java.io.Serializable;

public class Agenda implements Serializable{
	private String currentPage;
	private String pageSize;
	private String uuid;
	private String title;
	private String details;
	private String date;
	private String name;
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
