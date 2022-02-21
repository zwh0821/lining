package com.isuperone.lining.model.dto.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.util.*;

/**
 * @program: Lining
 * @description: 分页
 * @author: Joe
 * @create: 2020-04-25 10:59
 **/
public class PageDTO<T> implements Serializable {

    private T entity;
    private List<Map<String, Object>> paramMapList;
    private Page<T> page;

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }


    public List<Map<String, Object>> getParamMapList() {
        return paramMapList;
    }

    public void setParamMapList(List<Map<String, Object>> paramMapList) {
        this.paramMapList = paramMapList;
    }

    public Map<String,Object> getParamMap(){
        Map<String, Object> paramMap = new HashMap<>();
        if (paramMapList != null) {
            for (Map<String, Object> map : paramMapList) {
                if (map != null) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        paramMap.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        return paramMap;
    }

    public Page<T> getPage() {
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }

}