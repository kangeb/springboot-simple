package com.example.simple.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 日程实体类
 * 对应数据库表 ssmapi_agenda
 */
@ApiModel(value = "日程对象", description = "日程信息")
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页码（用于分页查询）
     */
    @ApiModelProperty(value = "当前页码")
    private String currentPage;

    /**
     * 每页大小（用于分页查询）
     */
    @ApiModelProperty(value = "每页大小")
    private String pageSize;

    /**
     * 日程唯一标识UUID
     */
    @ApiModelProperty(value = "日程UUID")
    private String uuid;

    /**
     * 日程标题
     */
    @ApiModelProperty(value = "日程标题", required = true)
    private String title;

    /**
     * 日程详情
     */
    @ApiModelProperty(value = "日程详情")
    private String details;

    /**
     * 日程日期
     */
    @ApiModelProperty(value = "日程日期")
    private String date;

    /**
     * 创建人姓名
     */
    @ApiModelProperty(value = "创建人姓名", required = true)
    private String name;

    /**
     * 备注
     */
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
