package com.isuperone.lining.controller.task;


import com.isuperone.lining.common.ReturnResult;
import com.isuperone.lining.common.ReturnResultUtils;
import com.isuperone.lining.common.annotation.UserLoginToken;
import com.isuperone.lining.common.enumration.ReturnResultContant;
import com.isuperone.lining.model.dto.common.TreeDto;
import com.isuperone.lining.model.entity.biz.BizTask;
import com.isuperone.lining.model.qo.task.TerminalDataQO;
import com.isuperone.lining.model.vo.task.TaskDataVO;
import com.isuperone.lining.queue.MsgProducer;
import com.isuperone.lining.service.inter.biz.IBizTaskTerminalDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
@RequestMapping("/task/bizTaskTerminalData")
@Validated
@Api(value = "/task/bizTaskTerminalData", tags = "bizTaskTerminalData", description = "终端数据相关接口")
public class BizTaskTerminalDataController {

    @Resource
    private IBizTaskTerminalDataService bizTaskTerminalDataService;

    @Resource
    private MsgProducer producer;

    @ResponseBody
    @RequestMapping(value = "/importTerminalData", method = RequestMethod.POST)
    @ApiOperation(notes = "importTerminalData",
            httpMethod = "POST",
            value = "上报任务终端数据",
            response = ReturnResult.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult importBizTaskTerminalData(@RequestBody TerminalDataQO terminalData) {
        try {
            HashMap<String,String> decodeDataMap = this.bizTaskTerminalDataService.importBizTaskTerminalData(terminalData);
            HashMap<String,String> encodeDataMap = new HashMap<>();
            encodeDataMap.put("L1", terminalData.getL1());
            encodeDataMap.put("L2", terminalData.getL2());
            encodeDataMap.put("L3", terminalData.getL3());
            encodeDataMap.put("L4", terminalData.getL4());
            encodeDataMap.put("L5", terminalData.getL5());
            encodeDataMap.put("R1", terminalData.getR1());
            encodeDataMap.put("R2", terminalData.getR2());
            encodeDataMap.put("R3", terminalData.getR3());
            encodeDataMap.put("R4", terminalData.getR4());
            encodeDataMap.put("R5", terminalData.getR5());
            encodeDataMap.put("Z0", terminalData.getZ0());
            encodeDataMap.put("Z1", terminalData.getZ1());
            encodeDataMap.put("Z2", terminalData.getZ2());
            encodeDataMap.put("Z3", terminalData.getZ3());
            encodeDataMap.put("Z4", terminalData.getZ4());
            encodeDataMap.put("horizontalDifference",Float.toString(terminalData.getHorizontalDifference()));
            encodeDataMap.put("verticalDifference",Float.toString(terminalData.getVerticalDifference()));
            encodeDataMap.put("compactness",Float.toString(terminalData.getCompactness()));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            encodeDataMap.put("createTime",formatter.format(new Date()));
            producer.sendMsg(decodeDataMap,encodeDataMap,terminalData.getTaskId().toString());
            if(decodeDataMap.get("flag").equals("false")){
                return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE,"部分上报数据校验失败");
            }
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("上报数据成功");
    }

    @ResponseBody
    @UserLoginToken
    @RequestMapping(value = "/getProjectTree", method = RequestMethod.POST)
    @ApiOperation(notes = "getProjectTree",
            httpMethod = "POST",
            value = "获取项目结构树",
            response = ReturnResult.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<List<TreeDto>> getProjectTree() {
        List<TreeDto> tree ;
        try {
           tree = this.bizTaskTerminalDataService.getProjectTree();
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(tree);
    }

    @ResponseBody
    @RequestMapping(value = "/getBizTaskTerminalData", method = RequestMethod.POST)
    @ApiOperation(notes = "getBizTaskTerminalData",
            httpMethod = "POST",
            value = "获取任务终端数据",
            response = ReturnResult.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult<TaskDataVO> getBizTaskTerminalData(@RequestBody BizTask bizTask) {
        TaskDataVO result;
        try {
            result = this.bizTaskTerminalDataService.getBizTaskTerminalData(bizTask);
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(result);
    }

}
