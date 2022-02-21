package com.isuperone.lining.model.vo.sys;

import java.util.List;

/**
 * @program: Lining
 * @description:
 * @author: Joe
 * @create: 2020-07-07 18:20
 **/
public class PermissionVO {

    private String id;

    private String name;

    boolean checkdAll;

    List<ActionVO> actionData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCheckdAll() {
        return checkdAll;
    }

    public void setCheckdAll(boolean checkdAll) {
        this.checkdAll = checkdAll;
    }

    public List<ActionVO> getActionData() {
        return actionData;
    }

    public void setActionData(List<ActionVO> actionData) {
        this.actionData = actionData;
    }
}
