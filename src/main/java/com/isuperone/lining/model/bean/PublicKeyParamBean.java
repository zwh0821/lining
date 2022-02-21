package com.isuperone.lining.model.bean;

/**
 * @program: Lining
 * @description:
 * @author: Joe
 * @create: 2020-12-04 15:47
 **/
public class PublicKeyParamBean {

    /**
     * version : 1
     * clientId : TL_App
     */

    private int version;
    private String clientId;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
