package com.isuperone.lining.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: Lining
 * @description: 页面控制器
 * @author: Joe
 * @create: 2020-03-28 10:08
 **/
public class HtmlController {

    @RequestMapping(value = "/list/table-list")
    public String TableList(){
        return "forward:/list/table-listConstants";
    }

}
