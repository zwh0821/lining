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
@RequestMapping("/project/bizTask")
@Validated
@Api(value = "/project/bizTask", tags = "bizTask", description = "任务相关接口")
public class BizTaskController {

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

}
