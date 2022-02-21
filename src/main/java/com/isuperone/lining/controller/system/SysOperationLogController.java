package com.isuperone.lining.controller.system;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isuperone.lining.common.ReturnResult;
import com.isuperone.lining.common.ReturnResultUtils;
import com.isuperone.lining.common.enumration.ReturnResultContant;
import com.isuperone.lining.model.dto.page.PageDTO;
import com.isuperone.lining.model.vo.sys.SysOperationLogVO;
import com.isuperone.lining.service.inter.sys.ISysOperationLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
@RestController
@RequestMapping("/system/operationLog")
@Api(value = "/operationLog", tags = "operationLog", description = "操作日志相关接口")
public class SysOperationLogController {

    @Resource
    private ISysOperationLogService sysOperationLogService;

    @ResponseBody
    @RequestMapping(value = {"findOperationLogPage"}, method = RequestMethod.POST)
    @ApiOperation(notes = "findOperationLogPage", httpMethod = "POST", value = "获取操作日志分页", response = ReturnResult.class)
    public ReturnResult<?> findOperationLogPage(@ApiParam(value = "获取操作日志分页") @RequestBody PageDTO<SysOperationLogVO> pageDTO) {
        Page<?> page;
        try {
            page = this.sysOperationLogService.findOperationLogPage(pageDTO.getPage(), pageDTO.getEntity(),pageDTO.getParamMap());
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(page);
    }

}
