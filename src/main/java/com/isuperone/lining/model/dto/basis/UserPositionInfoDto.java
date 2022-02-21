package com.isuperone.lining.model.dto.basis;

/**
 * @program: Lining
 * @description:
 * @author: Joe
 * @create: 2020-06-11 17:48
 **/
public class UserPositionInfoDto {

    private String name;

    private String telephone;

    private String position;

    private String enterpriseName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
}
