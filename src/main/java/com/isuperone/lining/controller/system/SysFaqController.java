package com.isuperone.lining.controller.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.isuperone.lining.common.ReturnResult;
import com.isuperone.lining.common.ReturnResultUtils;
import com.isuperone.lining.common.enumration.ReturnResultContant;
import com.isuperone.lining.model.dto.page.PageDTO;
import com.isuperone.lining.model.entity.sys.SysFaq;
import com.isuperone.lining.service.inter.sys.ISysFaqService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: Lining
 * @description:
 * @author: Joe
 * @create: 2020-06-14 19:51
 **/
@RestController
@RequestMapping("/system/sysFaq")
@Api(value = "/sysFaq", tags = "sysFaq", description = "帮助文档相关接口")
public class SysFaqController {

    @Resource
    ISysFaqService sysFaqService;

    @ResponseBody
    @RequestMapping(value = {"findSysFaqPage"}, method = RequestMethod.POST)
    @ApiOperation(notes = "findSysFaqPage", httpMethod = "POST", value = "获取帮助文档分页", response = ReturnResult.class)
    public ReturnResult<?> findySsFaqPage(@ApiParam(value = "获取帮助文档分页") @RequestBody PageDTO<SysFaq> pageDTO) {
        IPage<SysFaq> page;
        try {
            page = this.sysFaqService.findSysFaqPage(pageDTO.getPage(), pageDTO.getEntity());
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(page);
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(notes = "save", httpMethod = "POST", value = "保存帮助文档", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult saveSysFaq(@RequestBody SysFaq sysFaq) {
        try {
            int flag = this.sysFaqService.saveSysFaq(sysFaq);
            if (flag <= 0) {
                return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, "更新失败");
            }
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("保存成功");
    }

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ApiOperation(notes = "get", httpMethod = "POST", value = "获取帮助文档", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<SysFaq> getSysFaqInfo(@RequestBody SysFaq sysFaq) {
        SysFaq result;
        try {
            result = this.sysFaqService.getById(sysFaq.getId());
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(result);
    }

    @ResponseBody
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    @ApiOperation(notes = "remove", httpMethod = "POST", value = "删除帮助文档", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<SysFaq> removeSysFaq(@RequestBody SysFaq sysFaq) {
        try {
            int flag = this.sysFaqService.removeSysFaq(sysFaq);
            if (flag <= 0) {
                return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, "更新失败");
            }
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("删除成功");
    }

}
