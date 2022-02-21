package com.isuperone.lining.controller;

import com.isuperone.lining.common.ReturnResult;
import com.isuperone.lining.common.ReturnResultUtils;
import com.isuperone.lining.common.annotation.UserLoginToken;
import com.isuperone.lining.common.enumration.ReturnResultContant;
import com.isuperone.lining.model.vo.index.IndexDataVO;
import com.isuperone.lining.service.inter.biz.IBizTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: Lining
 * @description: 首页Controller
 * @author: Joe
 * @create: 2020-03-27 19:14
 **/

@RestController
@RequestMapping("/index")
@Validated
@Api(value = "/index", tags = "index", description = "首页相关")
public class IndexController {

    @Resource
    private IBizTaskService bizTaskService;

    @RequestMapping("/")
    public String index()
    {
       return "Index";
    }

    @ResponseBody
    @UserLoginToken
    @RequestMapping(value = "/indexData", method = RequestMethod.POST)
    @ApiOperation(notes = "/indexData", httpMethod = "POST", value = "首页数据", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<IndexDataVO> indexData() {
        IndexDataVO indexDataVO = new IndexDataVO();
        try {
            indexDataVO = bizTaskService.getIndexDataVo();
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(indexDataVO);
    }

}
