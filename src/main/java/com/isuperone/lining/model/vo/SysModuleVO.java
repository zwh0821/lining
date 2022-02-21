package com.isuperone.lining.model.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.isuperone.lining.model.entity.sys.SysModule;

/**
 * @program: Lining
 * @description: 模块view object
 * @author: Joe
 * @create: 2020-05-11 09:44
 **/
public class SysModuleVO extends SysModule {

    private String parentName;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
