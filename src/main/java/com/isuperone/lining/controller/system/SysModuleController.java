package com.isuperone.lining.controller.system;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isuperone.lining.common.ReturnResult;
import com.isuperone.lining.common.ReturnResultUtils;
import com.isuperone.lining.common.enumration.ReturnResultContant;
import com.isuperone.lining.model.dto.page.PageDTO;
import com.isuperone.lining.model.entity.sys.SysModule;
import com.isuperone.lining.model.vo.SysModuleVO;
import com.isuperone.lining.service.inter.sys.ISysModuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/system/module")
@Api(value = "/module", tags = "module", description = "模块/菜单相关接口")
public class SysModuleController {

    @Resource
    private ISysModuleService sysModuleService;


    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(notes = "save", httpMethod = "POST", value = "保存模块/菜单", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult saveModule(@RequestBody SysModule sysModule) {
        try {
            this.sysModuleService.saveModule(sysModule);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("保存成功");
    }

    @ResponseBody
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    @ApiOperation(notes = "remove", httpMethod = "POST", value = "删除", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult removeModule(@RequestBody SysModule sysModule) {
        try {
            this.sysModuleService.removeModule(sysModule);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("删除成功");
    }


    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ApiOperation(notes = "get", httpMethod = "POST", value = "获取模块/菜单", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<SysModule> getModuleInfo(@RequestBody SysModule sysModule) {
        SysModule result;
        try {
            result = this.sysModuleService.getById(sysModule.getId());
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(result);
    }

    @ResponseBody
    @RequestMapping(value = "/getMenuInfo", method = RequestMethod.POST)
    @ApiOperation(notes = "getMenuInfo", httpMethod = "POST", value = "获取模块/菜单", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<SysModuleVO> getMenu(@RequestBody SysModule sysModule) {
        SysModuleVO result;
        try {
            result = this.sysModuleService.getMenu(sysModule);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(result);
    }

    @ResponseBody
    @RequestMapping(value = {"findModulePage"}, method = RequestMethod.POST)
    @ApiOperation(notes = "findModulePage", httpMethod = "POST", value = "获取模块分页", response = ReturnResult.class)
    public ReturnResult<?> findModulePage(@ApiParam(value = "获取模块分页") @RequestBody PageDTO<SysModule> pageDTO) {
        Page<?> page;
        try {
            page = this.sysModuleService.findModulePage(pageDTO.getPage(), pageDTO.getEntity());
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(page);
    }

    @ResponseBody
    @RequestMapping(value = {"findMenuPage"}, method = RequestMethod.POST)
    @ApiOperation(notes = "findMenuPage", httpMethod = "POST", value = "获取菜单分页", response = ReturnResult.class)
    public ReturnResult<?> findMenuPage(@ApiParam(value = "获取菜单分页") @RequestBody PageDTO<SysModuleVO> pageDTO) {
        Page<?> page;
        try {
            page = this.sysModuleService.findMenuPage(pageDTO.getPage(), pageDTO.getEntity());
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(page);
    }


    @ResponseBody
    @RequestMapping(value = {"findModuleList"}, method = RequestMethod.POST)
    @ApiOperation(notes = "findModuleList", httpMethod = "POST", value = "获取菜单/模块列表", response = ReturnResult.class)
    public ReturnResult<List<SysModule>> findModuleList(@ApiParam(value = "获取菜单/模块列表") @RequestBody SysModule sysModule) {
        List<SysModule> sysModuleList;
        try {
            sysModuleList = this.sysModuleService.findModuleList(sysModule);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(sysModuleList);
    }


}
