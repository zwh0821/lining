package com.isuperone.lining.service.impl.biz;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isuperone.lining.common.enumration.*;
import com.isuperone.lining.common.exception.ServiceException;
import com.isuperone.lining.common.helper.CurrentUserUtil;
import com.isuperone.lining.common.helper.QrCodeUtils;
import com.isuperone.lining.mapper.biz.BizTaskMapper;
import com.isuperone.lining.model.dto.basis.UserLoginInfo;
import com.isuperone.lining.model.dto.task.RemarkDto;
import com.isuperone.lining.model.dto.task.TaskAttachmentDto;
import com.isuperone.lining.model.dto.task.TaskFilterConditionDto;
import com.isuperone.lining.model.dto.task.TaskRemarkDto;
import com.isuperone.lining.model.entity.biz.BizProject;
import com.isuperone.lining.model.entity.biz.BizTask;
import com.isuperone.lining.model.entity.sys.SysOperationLog;
import com.isuperone.lining.model.entity.sys.SysUser;
import com.isuperone.lining.model.qo.task.BizTaskQO;
import com.isuperone.lining.model.vo.index.IndexDataVO;
import com.isuperone.lining.model.vo.task.BizTaskVO;
import com.isuperone.lining.service.inter.biz.IBizTaskService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
@Service
public class BizTaskServiceImpl extends ServiceImpl<BizTaskMapper, BizTask> implements IBizTaskService {

    @Value("${file.staticQRcodeAccessPath}")
    private String staticQRcodeAccessPath;

    @Value("${file.qrCodeFolder}")
    private String qrCodeFolder;

    @Value("${file.baseUrl}")
    private String baseUrl;


    @Override
    public void saveBizTask(BizTask bizTask) {

    }

    @Override
    public int removeBizTask(BizTask bizTask) {
        BizTask task = this.baseMapper.selectById(bizTask.getId());
        if (task != null) {
            if (task.getStatus() != TaskStatusEnum.prepare.getCode()) {
                throw new ServiceException("删除失败，只有准备中的任务才允许删除");
            }
            return this.baseMapper.deleteById(bizTask.getId());
        } else {
            throw new ServiceException("删除失败，未获取到该任务信息");
        }
    }

    @Override
    public int startBizTask(BizTask bizTask) {
        return 0;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int submitBizTask(BizTaskQO bizTask) {
        BizTask task = this.baseMapper.selectById(bizTask.getId());
        Date now = new Date();
        if (task != null) {
            UserLoginInfo userLoginInfo = CurrentUserUtil.getCurrentUser();
            SysUser user = userLoginInfo.getUser();
            if (task.getStatus() != TaskStatusEnum.prepare.getCode()) {
                throw new ServiceException("任务自检失败，只有已准备的任务才允许自检通过");
            }
            return this.baseMapper.updateById(task);
        } else {
            throw new ServiceException("任务自检失败，未获取到该任务信息");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int auditBizTask(BizTaskQO bizTask) {
        BizTask task = this.baseMapper.selectById(bizTask.getId());
        Date now = new Date();
        if (task != null) {
            UserLoginInfo userLoginInfo = CurrentUserUtil.getCurrentUser();
            if (task.getStatus() != TaskStatusEnum.submit.getCode()) {
                throw new ServiceException("任务审核失败，只有已自检的任务才允许审批通过");
            }
            return this.baseMapper.updateById(task);
        } else {
            throw new ServiceException("任务审核失败，未获取到该任务信息");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int approveBizTask(BizTaskQO bizTask) {
        BizTask task = this.baseMapper.selectById(bizTask.getId());
        Date now = new Date();
        if (task != null) {
            UserLoginInfo userLoginInfo = CurrentUserUtil.getCurrentUser();
            if (task.getStatus() != TaskStatusEnum.audit.getCode()) {
                throw new ServiceException("审批任务失败，只有已审核的任务允许审批通过");
            }
            return this.baseMapper.updateById(task);
        } else {
            throw new ServiceException("审批任务失败，未获取到该任务信息");
        }
    }

    @Override
    public int rejectBizTask(BizTaskQO bizTask) {
        return 0;
    }

    @Override
    public int finishBizTask(BizTask bizTask) {
        BizTask task = this.baseMapper.selectById(bizTask.getId());
        if (task != null) {
            UserLoginInfo userLoginInfo = CurrentUserUtil.getCurrentUser();
            SysUser user = userLoginInfo.getUser();
            if (task.getStatus() != TaskStatusEnum.audit.getCode()
                    && task.getStatus() != TaskStatusEnum.start.getCode()) {
                throw new ServiceException("结束任务失败，只有已开始的任务才允许结束");
            }
            task.setStatus(TaskStatusEnum.finish.getCode());
            task.setFinishTime(new Date());
            List<Long> receivers = new ArrayList<>();
            receivers.add(task.getConstructorId());
            receivers.add(task.getQualityInspector());
            return this.baseMapper.updateById(task);
        } else {
            throw new ServiceException("结束任务失败，未获取到该任务信息");
        }
    }

    @Override
    public BizTaskVO getBizTask(BizTask bizTask) {
        BizTaskVO taskVO = null;
        return taskVO;
    }

    @Override
    public Page<BizTaskVO> findBizTaskPage(Page<BizTaskVO> page, BizTaskVO bizTaskVO, Map<String, Object> map) {
        UserLoginInfo loginInfo = CurrentUserUtil.getCurrentUser();
        SysUser user = loginInfo.getUser();
        String position = loginInfo.getPosition();
        this.baseMapper.findBizTaskPage(page, bizTaskVO, map);
        return page;
    }

    @Override
    public List<BizTask> findBizTaskList(BizTask bizTask) {
        QueryWrapper<BizTask> queryWrapper = this.getWrapper(bizTask);
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<BizTaskVO> getBizTaskExcel(List<Long> ids) {
        List<BizTaskVO> list = this.baseMapper.findExcelList(ids);
        return list;
    }

    public QueryWrapper<BizTask> getWrapper(BizTask bizTask) {
        QueryWrapper<BizTask> queryWrapper = new QueryWrapper<>();
        if (bizTask != null) {
            if (StringUtils.isNotEmpty(bizTask.getName())) {
                queryWrapper.like("taskName", bizTask.getName());
            }
            if (bizTask.getConstructionPoint() != null) {
                queryWrapper.eq("constructionPoint", bizTask.getConstructionPoint());
            }
        } else {
            throw new ServiceException("获取参数失败");
        }
        return queryWrapper;
    }

    @Override
    public IndexDataVO getIndexDataVo() {
        UserLoginInfo userLoginInfo = CurrentUserUtil.getCurrentUser();
        SysUser user = userLoginInfo.getUser();
        Integer projectSum = 0;
        Integer pointSum = 0;
        Integer taskSum = 0;
        Integer faultOrderSum = 0;
        List<HashMap<String, Object>> statusGroup = new ArrayList<>();
        List<HashMap<String, Object>> projectGroup = new ArrayList<>();
        List<HashMap<String, Object>> monGroup = new ArrayList<>();
        IndexDataVO indexDataVO = new IndexDataVO();
        indexDataVO.setProjectNum(projectSum);
        indexDataVO.setConstructionPointNum(pointSum);
        indexDataVO.setTaskNum(taskSum);
        indexDataVO.setFaultOrderNum(faultOrderSum);
        indexDataVO.setTaskStatisticsByMonth(monGroup);
        indexDataVO.setTaskStatisticsByPorject(projectGroup);
        indexDataVO.setStatusStatistics(statusGroup);
        return indexDataVO;
    }

}
