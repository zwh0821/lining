package com.isuperone.lining.controller.system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.isuperone.lining.common.ReturnResult;
import com.isuperone.lining.common.ReturnResultUtils;
import com.isuperone.lining.common.enumration.ReturnResultContant;
import com.isuperone.lining.model.dto.page.PageDTO;
import com.isuperone.lining.model.dto.system.SysRoleDto;
import com.isuperone.lining.model.entity.sys.SysRole;
import com.isuperone.lining.model.entity.sys.SysUser;
import com.isuperone.lining.model.requestParam.sys.sysRole.SaveRoleParam;
import com.isuperone.lining.model.vo.sys.SysRoleVO;
import com.isuperone.lining.service.impl.sys.SysRoleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/system/role")
@Api(value = "/role", tags = "role", description = "角色相关接口")
public class SysRoleController {

    @Autowired
    private SysRoleServiceImpl sysRoleService;

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(notes = "save", httpMethod = "POST", value = "保存角色", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult saveRole(@RequestBody SaveRoleParam para) {
        try {
            this.sysRoleService.saveRole(para);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("保存成功");
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(notes = "delete", httpMethod = "POST", value = "删除", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult removeRole(@RequestBody SysRole para) {
        try {
            this.sysRoleService.removeRole(para);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("删除成功");
    }


    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ApiOperation(notes = "get", httpMethod = "POST", value = "获取角色", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<SysRoleVO> getRoleInfo(@RequestBody SysRole sysRole) {
        SysRole result = new SysRole();
        try {
            result = this.sysRoleService.getRoleInfo(sysRole);
            System.out.println();
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(result);
    }


    @ResponseBody
    @RequestMapping(value = {"findPage"}, method = RequestMethod.POST)
    @ApiOperation(notes = "findPage", httpMethod = "POST", value = "获取角色列表", response = ReturnResult.class)
    public ReturnResult<Page<SysRole>> findRolePage(@ApiParam(value = "获取角色列表") @RequestBody PageDTO<SysRole> pageDTO) {
        Page<SysRole> page = new Page<SysRole>();
        try {
            page = this.sysRoleService.findRolePage(pageDTO.getPage(), pageDTO.getEntity());

        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getCause().toString());
        }
        return ReturnResultUtils.returnSuccess(page);
    }

    @ResponseBody
    @RequestMapping(value = {"findList"}, method = RequestMethod.POST)
    @ApiOperation(notes = "findList", httpMethod = "POST", value = "获取角色列表", response = ReturnResult.class)
    public ReturnResult<List<SysRole>> findRoleList(@ApiParam(value = "获取角色列表") @RequestBody SysRole sysRole) {
        List<SysRole> list;
        try {
            list = this.sysRoleService.findRoleList(sysRole);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getCause().toString());
        }
        return ReturnResultUtils.returnSuccess(list);
    }
}
