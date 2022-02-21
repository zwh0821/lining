package com.isuperone.lining.controller.system;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.isuperone.lining.common.ReturnResult;
import com.isuperone.lining.common.ReturnResultUtils;
import com.isuperone.lining.common.enumration.ReturnResultContant;
import com.isuperone.lining.model.dto.page.PageDTO;
import com.isuperone.lining.model.entity.sys.SysConfig;
import com.isuperone.lining.model.vo.sys.VersionCheckVO;
import com.isuperone.lining.service.inter.sys.ISysConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/system/sysConfig")
@Api(value = "/sysConfig", tags = "sysConfig", description = "系统配置相关接口")
public class SysConfigController {

    @Resource
    ISysConfigService sysConfigService;


    @ResponseBody
    @RequestMapping(value = {"checkVersion"}, method = RequestMethod.POST)
    @ApiOperation(notes = "checkVersion", httpMethod = "POST", value = "检查更新", response = ReturnResult.class)
    public ReturnResult<VersionCheckVO> checkVersion() {
        VersionCheckVO versionCheckVO = new VersionCheckVO();
        versionCheckVO.setAddress(this.sysConfigService.getConfigByConfigKey("AppUdateAddress").getConfigValue());
        versionCheckVO.setUpdateDetail(this.sysConfigService.getConfigByConfigKey("AppUpdateDescription").getConfigValue());
        versionCheckVO.setVersion(Integer.parseInt(this.sysConfigService.getConfigByConfigKey("APPVersion").getConfigValue()));
        versionCheckVO.setVersionName(this.sysConfigService.getConfigByConfigKey("AppVersionName").getConfigValue());
        return ReturnResultUtils.returnSuccess(versionCheckVO);
    }

    @ResponseBody
    @RequestMapping(value = {"findSysConfigPage"}, method = RequestMethod.POST)
    @ApiOperation(notes = "findSysConfigPage", httpMethod = "POST", value = "获取系统配置分页", response = ReturnResult.class)
    public ReturnResult<?> findSysConfigPage(@ApiParam(value = "获取系统配置分页") @RequestBody PageDTO<SysConfig> pageDTO) {
        IPage<SysConfig> page;
        try {
            page = this.sysConfigService.findSysConfigPage(pageDTO.getPage(), pageDTO.getEntity());
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(page);
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(notes = "save", httpMethod = "POST", value = "保存系统配置", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult saveSysConfig(@RequestBody SysConfig sysConfig) {
        try {
            int flag = this.sysConfigService.saveSysConfig(sysConfig);
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
    @ApiOperation(notes = "get", httpMethod = "POST", value = "获取系统配置", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<SysConfig> getSysConfigInfo(@RequestBody SysConfig sysConfig) {
        SysConfig result;
        try {
            result = this.sysConfigService.getById(sysConfig.getId());
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(result);
    }

    @ResponseBody
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    @ApiOperation(notes = "remove", httpMethod = "POST", value = "删除系统配置", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<SysConfig> removeSysConfig(@RequestBody SysConfig sysConfig) {
        try {
            int flag = this.sysConfigService.removeSysConfig(sysConfig);
            if (flag <= 0) {
                return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, "更新失败");
            }
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("删除成功");
    }


}
