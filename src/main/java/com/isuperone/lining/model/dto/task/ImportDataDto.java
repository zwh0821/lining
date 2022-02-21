package com.isuperone.lining.model.dto.task;

import com.isuperone.lining.model.qo.task.TerminalDataQO;

import java.util.HashMap;

/**
 * @program: Lining
 * @description: 上报数据的实体
 * @author: Joe
 * @create: 2020-06-11 10:35
 **/
public class ImportDataDto {

    private HashMap<String,String> decodeData;

    private HashMap<String, String> encodeData;

    private HashMap<String,Object> calData;

    public HashMap<String, String> getDecodeData() {
        return decodeData;
    }

    public void setDecodeData(HashMap<String, String> decodeData) {
        this.decodeData = decodeData;
    }

    public HashMap<String, String> getEncodeData() {
        return encodeData;
    }

    public void setEncodeData(HashMap<String, String> encodeData) {
        this.encodeData = encodeData;
    }

    public HashMap<String, Object> getCalData() {
        return calData;
    }

    public void setCalData(HashMap<String, Object> calData) {
        this.calData = calData;
    }
}
