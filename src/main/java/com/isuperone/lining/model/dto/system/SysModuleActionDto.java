package com.isuperone.lining.model.dto.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.isuperone.lining.model.entity.sys.SysModule;
import com.isuperone.lining.model.entity.sys.SysModuleAction;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @program: Lining
 * @description:
 * @author: Joe
 * @create: 2020-07-07 15:35
 **/
public class SysModuleActionDto extends SysModule {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long moduleId;

    private List<SysModuleAction> actionDtos;

    private List<String> actions;

    private List<SysModuleActionDto> children;

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public List<SysModuleAction> getActionDtos() {
        return actionDtos;
    }

    public void setActionDtos(List<SysModuleAction> actionDtos) {
        this.actionDtos = actionDtos;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }

    public List<SysModuleActionDto> getChildren() {
        return children;
    }

    public void setChildren(List<SysModuleActionDto> children) {
        this.children = children;
    }
}
