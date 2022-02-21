package com.isuperone.lining.model.vo;

import com.isuperone.lining.model.entity.sys.SysModule;
import com.isuperone.lining.model.entity.sys.SysModuleAction;

import java.util.List;

/**
 * @program: Lining
 * @description: ModuleAction Object
 * @author: Joe
 * @create: 2020-05-13 14:56
 **/
public class SysModuleActionVo extends SysModule {

    public List<SysModuleAction> actionList;

    public List<String> actions;

    public List<SysModuleAction> getActionList() {
        return actionList;
    }

    public void setActionList(List<SysModuleAction> actionList) {
        this.actionList = actionList;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }
}
