package com.isuperone.lining.model.entity.sys;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
public class SysModule implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 父级id，为0则是顶级菜单
     */
    @TableField("parentId")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;

    /**
     * 层级
     */
    private Integer grade;

    /**
     * 图标
     */
    private String icon;

    /**
     * 菜单地址
     */
    private String url;

    /**
     * 模块名
     */
    @TableField("moduleName")
    private String moduleName;

    /**
     * 是否菜单
     */
    @TableField("isMenu")
    private Boolean isMenu;

    /**
     * 描述
     */
    @TableField("description")
    private String description;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态
     */
    private Integer status;

    @TableField("createTime")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    public Boolean getMenu() {
        return isMenu;
    }

    public void setMenu(Boolean isMenu) {
        this.isMenu = isMenu;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SysModule{" +
        "parentId=" + parentId +
        ", grade=" + grade +
        ", icon=" + icon +
        ", url=" + url +
        ", moduleName=" + moduleName +
        ", isMenu=" + isMenu +
        ", description=" + description +
        ", sort=" + sort +
        ", status=" + status +
        ", createTime=" + createTime +
        "}";
    }
}
