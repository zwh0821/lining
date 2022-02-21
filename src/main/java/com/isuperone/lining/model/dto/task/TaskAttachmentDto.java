package com.isuperone.lining.model.dto.task;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @program: Lining
 * @description: 附件Dto
 * @author: Joe
 * @create: 2020-05-29 11:20
 **/
public class TaskAttachmentDto {
    /**
     * 防水层照片
     */
    @TableField("waterproofLayer")
    @ApiModelProperty(value = "防水层照片")
    private List<String> waterproofLayers;

    /**
     * 钢筋影像
     */
    @ApiModelProperty(value = "钢筋影像")
    private List<String> rebars;

    /**
     * 台车影像
     */
    @ApiModelProperty(value = "台车影像")
    private List<String> trolleys;

    /**
     * 传感器影像
     */
    @ApiModelProperty(value = "传感器影像")
    private List<String> sensors;

    /**
     * 工控机影像
     */
    @ApiModelProperty(value = "工控机影像")
    private List<String> ipcs;

    /**
     * 洞口路由影像
     */
    @ApiModelProperty(value = "洞口路由影像")
    private List<String> routes;

    /**
     * 施工员就绪影像
     */
    @ApiModelProperty(value = "施工员就绪影像")
    private List<String> constructors;

    /**
     * 质检员就绪影像
     */
    @ApiModelProperty(value = "质检员就绪影像")
    @TableField("qualityInspector")
    private List<String> qualityInspectors;

    /**
     * 监理员就绪影像
     */
    @ApiModelProperty(value = "监理员就绪影像")
    private List<String> supervisors;

    public List<String> getWaterproofLayers() {
        return waterproofLayers;
    }

    public void setWaterproofLayers(List<String> waterproofLayers) {
        this.waterproofLayers = waterproofLayers;
    }

    public List<String> getRebars() {
        return rebars;
    }

    public void setRebars(List<String> rebars) {
        this.rebars = rebars;
    }

    public List<String> getTrolleys() {
        return trolleys;
    }

    public void setTrolleys(List<String> trolleys) {
        this.trolleys = trolleys;
    }

    public List<String> getSensors() {
        return sensors;
    }

    public void setSensors(List<String> sensors) {
        this.sensors = sensors;
    }

    public List<String> getIpcs() {
        return ipcs;
    }

    public void setIpcs(List<String> ipcs) {
        this.ipcs = ipcs;
    }

    public List<String> getRoutes() {
        return routes;
    }

    public void setRoutes(List<String> routes) {
        this.routes = routes;
    }

    public List<String> getConstructors() {
        return constructors;
    }

    public void setConstructors(List<String> constructors) {
        this.constructors = constructors;
    }

    public List<String> getQualityInspectors() {
        return qualityInspectors;
    }

    public void setQualityInspectors(List<String> qualityInspectors) {
        this.qualityInspectors = qualityInspectors;
    }

    public List<String> getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(List<String> supervisors) {
        this.supervisors = supervisors;
    }

}
