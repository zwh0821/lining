package com.isuperone.lining.model.dto.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.List;

/**
 * @program: Lining
 * @description: 树结构
 * @author: Joe
 * @create: 2020-05-25 10:53
 **/
public class TreeDto {


    @JsonSerialize(using = ToStringSerializer.class)
    public Long key;

    public String title;

    public List<TreeDto> children;

    public void setKey(Long key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TreeDto> getChildren() {
        return children;
    }

    public void setChildren(List<TreeDto> children) {
        this.children = children;
    }
}
