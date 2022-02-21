package com.isuperone.lining.model.entity.sys;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class SysModuleAction implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @TableField("moduleId")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long moduleId;

    /**
     * 动作：add,get,query,update,delete,import,outport
     */
    private String action;

    /**
     * 描述（新增，修改，删除，查询，详情，导入，导出）
     */
    private String description;

    /**
     * 默认是否选中
     */
    @TableField("defaultCheck")
    private Boolean defaultCheck;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Boolean getDefaultCheck() {
        return defaultCheck;
    }

    public void setDefaultCheck(Boolean defaultCheck) {
        this.defaultCheck = defaultCheck;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SysModuleAction{" +
        "moduleId=" + moduleId +
        ", action=" + action +
        ", description=" + description +
        ", defaultCheck=" + defaultCheck +
        ", createTime=" + createTime +
        "}";
    }
}
