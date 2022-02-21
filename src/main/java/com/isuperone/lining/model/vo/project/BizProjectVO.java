package com.isuperone.lining.model.vo.project;

import com.isuperone.lining.model.entity.biz.BizProject;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: Lining
 * @description: Project View Object
 * @author: Joe
 * @create: 2020-05-14 18:25
 **/
public class BizProjectVO extends BizProject {

    @ApiModelProperty(value = "单位名称")
    private String enterpriseName;

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
}
