package com.isuperone.lining.controller.system;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isuperone.lining.common.ReturnResult;
import com.isuperone.lining.common.ReturnResultUtils;
import com.isuperone.lining.common.enumration.ReturnResultContant;
import com.isuperone.lining.model.dto.page.PageDTO;
import com.isuperone.lining.model.dto.system.PermissionDto;
import com.isuperone.lining.model.dto.system.SysModuleActionDto;
import com.isuperone.lining.model.entity.sys.SysModule;
import com.isuperone.lining.model.vo.SysModuleActionVo;
import com.isuperone.lining.model.vo.SysUserVO;
import com.isuperone.lining.model.vo.sys.PermissionVO;
import com.isuperone.lining.service.inter.sys.ISysModuleActionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/system/moduleAction")
@Validated
@Api(value = "/system/moduleAction", tags = "moduleAction", description = "权限相关接口")
public class SysModuleActionController {

    @Resource
    private ISysModuleActionService sysModuleActionService;

    @ResponseBody
    @RequestMapping(value = {"findPage"}, method = RequestMethod.POST)
    @ApiOperation(notes = "findPage", httpMethod = "POST", value = "获取权限列表", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<Page<SysModuleActionVo>> findPage(@ApiParam(value = "获取用户列表") @RequestBody PageDTO<SysModuleActionDto> pageDTO) {
        Page<SysModuleActionDto> page;
        try {
            page = this.sysModuleActionService.findModuleActionPage(pageDTO.getPage(),pageDTO.getEntity());
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getCause().toString());
        }
        return ReturnResultUtils.returnSuccess(page);
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(notes = "save", httpMethod = "POST", value = "保存权限列表", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult saveModule(@RequestBody SysModuleActionDto sysModule) {
        try {
            this.sysModuleActionService.saveModuleAction(sysModule);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("保存成功");
    }

    @ResponseBody
    @RequestMapping(value = "/getPermissonData", method = RequestMethod.POST)
    @ApiOperation(notes = "getPermissonData", httpMethod = "POST", value = "获取所有权限Action数据", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<List<PermissionDto>> getPermissonData( ) {
        List<PermissionDto> result = new ArrayList<>();
        try {
            result = this.sysModuleActionService.getPermissonData();
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(result);
    }
}
