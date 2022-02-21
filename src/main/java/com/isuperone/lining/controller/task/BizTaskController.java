package com.isuperone.lining.controller.task;


import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isuperone.lining.common.ReturnResult;
import com.isuperone.lining.common.ReturnResultUtils;
import com.isuperone.lining.common.annotation.UserLoginToken;
import com.isuperone.lining.common.enumration.ReturnResultContant;
import com.isuperone.lining.common.helper.ExportExcelUtils;
import com.isuperone.lining.common.helper.QrCodeUtils;
import com.isuperone.lining.model.dto.page.PageDTO;
import com.isuperone.lining.model.entity.biz.BizTask;
import com.isuperone.lining.model.qo.task.BizTaskQO;
import com.isuperone.lining.model.vo.task.BizTaskVO;
import com.isuperone.lining.service.inter.biz.IBizTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
@RequestMapping("/task/bizTask")
@Validated
@Api(value = "/task/bizTask", tags = "bizTask", description = "任务相关接口")
public class BizTaskController {

    @Resource
    private IBizTaskService bizTaskService;

    @Value("${file.staticQRcodeAccessPath}")
    private String staticQRcodeAccessPath;


    @Value("${file.qrCodeFolder}")
    private String qrCodeFolder;

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @UserLoginToken
    @ApiOperation(notes = "save", httpMethod = "POST", value = "保存任务", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult saveTask(@RequestBody BizTask bizTask) {
        try {
            this.bizTaskService.saveBizTask(bizTask);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("保存成功");
    }

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ApiOperation(notes = "get", httpMethod = "POST", value = "获取任务", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<BizTaskVO> getTaskInfo(@RequestBody BizTaskVO bizTask) {
        BizTaskVO result;
        try {
            result = this.bizTaskService.getBizTask(bizTask);
            if (result == null) {
                return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, "未能通过任务主键获取任务信息");
            }
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(result);
    }

    @ResponseBody
    @UserLoginToken
    @RequestMapping(value = {"findPage"}, method = RequestMethod.POST)
    @ApiOperation(notes = "findPage", httpMethod = "POST", value = "获取任务列表", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<Page<BizTaskVO>> findTaskPage(@ApiParam(value = "获取任务列表") @RequestBody PageDTO<BizTaskVO> pageDTO) {
        Page<BizTaskVO> page;
        try {
            page = this.bizTaskService.findBizTaskPage(pageDTO.getPage(), pageDTO.getEntity(), pageDTO.getParamMap());
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getCause().toString());
        }
        return ReturnResultUtils.returnSuccess(page);
    }

    @ResponseBody
    @UserLoginToken
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    @ApiOperation(notes = "remove", httpMethod = "POST", value = "删除任务", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<BizTask> removeTask(@RequestBody BizTask bizTask) {
        try {
            int result = this.bizTaskService.removeBizTask(bizTask);
            if (result < 1) {
                return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, "删除失败");
            }
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("删除成功");
    }

    @ResponseBody
    @RequestMapping(value = {"findList"}, method = RequestMethod.POST)
    @ApiOperation(notes = "findList", httpMethod = "POST", value = "获取任务列表", response = ReturnResult.class)
    public ReturnResult<List<BizTask>> findTaskList(@ApiParam(value = "获取任务列表") @RequestBody BizTask bizTask) {
        List<BizTask> bizTaskList;
        try {
            bizTaskList = this.bizTaskService.findBizTaskList(bizTask);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(bizTaskList);
    }

    @ResponseBody
    @UserLoginToken
    @RequestMapping(value = "/start", method = RequestMethod.POST)
    @ApiOperation(notes = "start", httpMethod = "POST", value = "开始任务", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult startBizTask(@RequestBody BizTask bizTask) {
        try {
            int result = this.bizTaskService.startBizTask(bizTask);
            if (result < 1) {
                return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, "开始任务失败");
            }
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("开始任务成功");
    }

    @ResponseBody
    @UserLoginToken
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ApiOperation(notes = "submit", httpMethod = "POST", value = "提交审核任务", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult submitBizTask(@RequestBody BizTaskQO bizTask) {
        try {
            int result = this.bizTaskService.submitBizTask(bizTask);
            if (result < 1) {
                return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, "任务提交审核失败");
            }
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("任务提交审核成功");
    }

    @ResponseBody
    @UserLoginToken
    @RequestMapping(value = "/audit", method = RequestMethod.POST)
    @ApiOperation(notes = "audit", httpMethod = "POST", value = "审核任务", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult auditBizTask(@RequestBody BizTaskQO bizTask) {
        try {
            int result = this.bizTaskService.auditBizTask(bizTask);
            if (result < 1) {
                return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, "任务审核失败");
            }
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("任务审核成功");
    }

    @ResponseBody
    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    @UserLoginToken
    @ApiOperation(notes = "approve", httpMethod = "POST", value = "审批任务", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult approveBizTask(@RequestBody BizTaskQO bizTask) {
        try {
            int result = this.bizTaskService.approveBizTask(bizTask);
            if (result < 1) {
                return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, "任务审批失败");
            }
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("任务审批成功");
    }

    @ResponseBody
    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    @UserLoginToken
    @ApiOperation(notes = "reject", httpMethod = "POST", value = "驳回任务", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult rejectBizTask(@RequestBody BizTaskQO bizTask) {
        try {
            int result = this.bizTaskService.rejectBizTask(bizTask);
            if (result < 1) {
                return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, "任务审批失败");
            }
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("驳回成功");
    }

    @UserLoginToken
    @RequestMapping(value = "/finish", method = RequestMethod.POST)
    @ApiOperation(notes = "finish", httpMethod = "POST", value = "结束任务", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult finishBizTask(@RequestBody BizTask bizTask) {
        try {
            int result = this.bizTaskService.finishBizTask(bizTask);
            if (result < 1) {
                return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, "任务结束失败");
            }
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("任务结束成功");
    }

    @RequestMapping(value = "/exportExcel",method = RequestMethod.POST,produces = "application/octet-stream")
    @ApiOperation(notes = "exportExcel", httpMethod = "POST", value = "导出报表",produces = "application/octet-stream")
    public void exportBizTaskExcel(HttpServletResponse response, HttpServletRequest request,@RequestBody List<Long> ids){

        //得到所有要导出的数据
        List<BizTaskVO> taskList =this.bizTaskService.getBizTaskExcel(ids);
        //定义导出的excel名字
        String excelName = "任务简报";

        //获取需要转出的excel表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("name","任务名称");
        fieldMap.put("projectName","所属项目");
        fieldMap.put("supervisionSectionName","所属监理标");
        fieldMap.put("statusName","状态");
        fieldMap.put("constructorName","施工员");
        fieldMap.put("supervisorName","监理员");
        fieldMap.put("qualityInspectorName","质检员");

        //导出用户相关信息
        ExportExcelUtils.export(excelName,taskList,fieldMap,response);
    }


    @RequestMapping(value = "/createQRCode",method = RequestMethod.POST)
    @ApiOperation(notes = "createQRCode", httpMethod = "POST", value = "生成二维码")
    public ReturnResult createQRCode(@RequestParam String taskId , HttpServletRequest request, HttpServletResponse response){
        try {
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("taskId",taskId);
            QrCodeUtils.zxingCodeCreate(JSONUtil.toJsonStr(hashMap),staticQRcodeAccessPath,null,qrCodeFolder+taskId);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("任务结束成功");
    }
}
