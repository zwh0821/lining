package com.isuperone.lining.controller.system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isuperone.lining.common.ReturnResult;
import com.isuperone.lining.common.ReturnResultUtils;
import com.isuperone.lining.common.annotation.UserLoginToken;
import com.isuperone.lining.common.enumration.ReturnResultContant;
import com.isuperone.lining.model.dto.LoginDto;
import com.isuperone.lining.model.dto.basis.*;
import com.isuperone.lining.model.dto.page.PageDTO;
import com.isuperone.lining.model.entity.sys.SysUser;
import com.isuperone.lining.model.qo.LoginQo;
import com.isuperone.lining.model.vo.SysUserVO;
import com.isuperone.lining.service.impl.sys.SysUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @program: Lining
 * @description: 用户控制器类
 * @author: Joe
 * @create: 2020-03-27 12:23
 **/


@RestController
@RequestMapping("/system/user")
@Api(value = "/system/user", tags = "user", description = "用户相关接口")
public class SysUserController {

    @Autowired
    private SysUserServiceImpl userService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(notes = "login", httpMethod = "POST", value = "登录", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<LoginDto> userLogin(@RequestBody @Valid LoginQo para) {
        LoginDto loginDto;
        try {
            loginDto = this.userService.login(para);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        System.out.println(loginDto.toString());
        return ReturnResultUtils.returnSuccess(loginDto);
    }

    @UserLoginToken
    @ResponseBody
    @RequestMapping("/info")
    public ReturnResult<UserInfo> info() {
        UserInfo result = new UserInfo();
        try {
            result = this.userService.userLoginInfo();
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(result);
    }


    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(notes = "save", httpMethod = "POST", value = "保存用户", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult save(@RequestBody SysUserVO sysUserVO) {
        try {
            this.userService.saveUser(sysUserVO);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("保存成功");
    }

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ApiOperation(notes = "get", httpMethod = "POST", value = "获取用户", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<SysUser> get(@RequestBody SysUserVO sysUserVO) {
        SysUser result;
        try {
            result = this.userService.getUserInfo(sysUserVO);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(result);
    }

    @ResponseBody
    @RequestMapping(value = {"findPage"}, method = RequestMethod.POST)
    @ApiOperation(notes = "findPage", httpMethod = "POST", value = "获取用户列表", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<Page<SysUserVO>> findUserPage(@ApiParam(value = "获取用户列表") @RequestBody PageDTO<SysUserVO> pageDTO) {
        Page<SysUserVO> page;
        try {
            page = this.userService.findUserPage(pageDTO.getPage(), pageDTO.getEntity());
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getCause().toString());
        }
        return ReturnResultUtils.returnSuccess(page);
    }

    @ResponseBody
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    @ApiOperation(notes = "remove", httpMethod = "POST", value = "删除用户", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<SysUser> remove(@RequestBody SysUserVO sysUserVO) {
        try {
            this.userService.removeUser(sysUserVO);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("删除成功");
    }

    @ResponseBody
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    @ApiOperation(notes = "getUserInfo", httpMethod = "POST", value = "APP获取用户信息", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<UserPositionInfoDto> get(@RequestParam String userId) {
        UserPositionInfoDto result;
        try {
            result = this.userService.getPositonInfo(Long.parseLong(userId));
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(result);
    }

    @ResponseBody
    @RequestMapping(value = "/app/login", method = RequestMethod.POST)
    @ApiOperation(notes = "/app/login", httpMethod = "POST", value = "APP登录", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<AppLoginVO> appLogin(@RequestBody @Valid LoginQo para) {
        try {
            AppLoginVO result = this.userService.appLogin(para);
            return ReturnResultUtils.returnSuccess(result);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
    }

}
