package com.isuperone.lining.model.dto.basis;

import com.isuperone.lining.model.entity.sys.SysUser;

/**
 * @program: Lining
 * @description: 登录信息
 * @author: Joe
 * @create: 2020-06-10 12:24
 **/
public class UserLoginInfo {

    private SysUser user;

    private String position;

    private Long enterpriseId;

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}
