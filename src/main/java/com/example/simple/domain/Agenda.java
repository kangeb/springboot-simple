package com.example.simple.domain;

import java.io.Serializable;

/**
 * 日程实体类
 * 对应数据库表ssmapi_agenda
 */
public class Agenda implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /** 当前页码 */
    private String currentPage;
    /** 每页大小 */
    private String pageSize;
    /** 日程唯一标识 */
    private String uuid;
    /** 日程标题 */
    private String title;
    /** 日程详情 */
    private String details;
    /** 日程日期 */
    private String date;
    /** 日程所属用户名 */
    private String name;
    /** 备注 */
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
