package com.isuperone.lining.controller.project;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isuperone.lining.common.ReturnResult;
import com.isuperone.lining.common.ReturnResultUtils;
import com.isuperone.lining.common.annotation.UserLoginToken;
import com.isuperone.lining.common.enumration.ReturnResultContant;
import com.isuperone.lining.model.dto.page.PageDTO;
import com.isuperone.lining.model.entity.biz.BizProject;
import com.isuperone.lining.model.vo.project.BizProjectVO;
import com.isuperone.lining.service.inter.biz.IBizProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/project/bizProject")
@Validated
@Api(value = "/project/bizProject", tags = "bizProject", description = "项目相关接口")
public class BizProjectController {

    @Resource
    private IBizProjectService bizProjectService;

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(notes = "save", httpMethod = "POST", value = "保存项目", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult saveProject(@RequestBody BizProject bizProject) {
        try {
            this.bizProjectService.saveBizProject(bizProject);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("保存成功");
    }

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ApiOperation(notes = "get", httpMethod = "POST", value = "获取项目", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<BizProject> getProjectInfo(@RequestBody BizProject bizProject) {
        BizProject result;
        try {
            result = this.bizProjectService.getBizProject(bizProject);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(result);
    }

    @ResponseBody
    @RequestMapping(value = {"findPage"}, method = RequestMethod.POST)
    @ApiOperation(notes = "findPage", httpMethod = "POST", value = "获取项目列表", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<Page<BizProjectVO>> findProjectPage(@ApiParam(value = "获取项目列表") @RequestBody PageDTO<BizProjectVO> pageDTO) {
        Page<BizProjectVO> page;
        try {
            page = this.bizProjectService.findBizProjectPage(pageDTO.getPage(), pageDTO.getEntity());
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getCause().toString());
        }
        return ReturnResultUtils.returnSuccess(page);
    }

    @ResponseBody
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    @ApiOperation(notes = "remove", httpMethod = "POST", value = "删除项目", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<BizProject> removeProject(@RequestBody BizProject bizProject) {
        try {
            this.bizProjectService.removeBizProject(bizProject);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("删除成功");
    }

    @ResponseBody
    @UserLoginToken
    @RequestMapping(value = {"findList"}, method = RequestMethod.POST)
    @ApiOperation(notes = "findList", httpMethod = "POST", value = "获取项目列表", response = ReturnResult.class)
    public ReturnResult<List<BizProject>> findProjectList(@ApiParam(value = "获取项目列表") @RequestBody BizProject bizProject) {
        List<BizProject> bizProjectList;
        try {
            bizProjectList = this.bizProjectService.findBizProjectList(bizProject);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(bizProjectList);
    }

}
