package com.isuperone.lining.controller.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.isuperone.lining.common.ReturnResult;
import com.isuperone.lining.common.ReturnResultUtils;
import com.isuperone.lining.common.enumration.PositionEnum;
import com.isuperone.lining.common.enumration.ReturnResultContant;
import com.isuperone.lining.queue.MsgProducer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Lining
 * @description: 通用接口
 * @author: Joe
 * @create: 2020-05-14 12:21
 **/

@RestController
@RequestMapping("/common")
@Api(value = "/common", tags = "common", description = "通用相关接口")
public class CommonController {


    @Resource
    private MsgProducer msgProducer;


    @ResponseBody
    @RequestMapping(value = "/getPositionList", method = RequestMethod.POST)
    @ApiOperation(notes = "getPositionList", httpMethod = "POST", value = "获取职务列表", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult getPositionList() {
        List result = new ArrayList<>();
        try {
            for(PositionEnum s :PositionEnum.values()){
                Map<String,Object> map = new HashMap<>();
                map.put("key",s.getCode());
                map.put("value",s.getMessage());
                result.add(map);
            }
        } catch (Exception e) {
            return ReturnResultUtils.returnFail(ReturnResultContant.FAILURE, e.getMessage());
        }
        return ReturnResultUtils.returnSuccess(result);
    }

    @ResponseBody
    @RequestMapping(value = "/importTest", method = RequestMethod.POST)
    @ApiOperation(notes = "importTest", httpMethod = "POST", value = "测试滚动数据", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnResult importTest(String taskId){
        HashMap<String,String> data = new HashMap<>();
        data.put("taskId",taskId);
        try {
            msgProducer.sendMsg(data,new HashMap<>(),taskId);
        } catch (JsonProcessingException e) {
            return ReturnResultUtils.returnFail(0,e.getMessage());
        }
        return ReturnResultUtils.returnSuccess("发送成功");
    }

}
