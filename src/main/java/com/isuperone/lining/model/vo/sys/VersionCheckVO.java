package com.isuperone.lining.model.vo.sys;

import io.swagger.annotations.ApiModelProperty;

/**
 * @program: Lining
 * @description: 版本检查View Object
 * @author: Joe
 * @create: 2020-06-14 19:59
 **/
public class VersionCheckVO {

    @ApiModelProperty(value = "下载地址")
    private String address;

    @ApiModelProperty(value = "版本名称")
    private String versionName;

    @ApiModelProperty(value = "版本号")
    private Integer version;

    @ApiModelProperty(value = "更新内容")
    private String updateDetail;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getUpdateDetail() {
        return updateDetail;
    }

    public void setUpdateDetail(String updateDetail) {
        this.updateDetail = updateDetail;
    }
}
