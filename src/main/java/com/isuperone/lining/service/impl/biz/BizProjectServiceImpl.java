package com.isuperone.lining.service.impl.biz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isuperone.lining.common.enumration.EnterpriseCategoryEnum;
import com.isuperone.lining.common.enumration.PositionEnum;
import com.isuperone.lining.common.enumration.UserTypeEnum;
import com.isuperone.lining.common.exception.ServiceException;
import com.isuperone.lining.common.helper.CurrentUserUtil;
import com.isuperone.lining.mapper.biz.BizProjectMapper;
import com.isuperone.lining.model.dto.basis.UserLoginInfo;
import com.isuperone.lining.model.dto.task.TaskFilterConditionDto;
import com.isuperone.lining.model.entity.biz.BizProject;
import com.isuperone.lining.model.entity.sys.SysUser;
import com.isuperone.lining.model.vo.project.BizProjectVO;
import com.isuperone.lining.service.inter.biz.IBizProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
@Service
public class BizProjectServiceImpl extends ServiceImpl<BizProjectMapper, BizProject> implements IBizProjectService {

    @Override
    public void saveBizProject(BizProject bizProject) {
        QueryWrapper<BizProject> ew = new QueryWrapper<>();
        ew.eq("projectName", bizProject.getProjectName());
        if (bizProject.getId() != null) {
            ew.ne("id", bizProject.getId());
        }
        List<BizProject> query = this.baseMapper.selectList(ew);
        if (query.size() > 0) {
            throw new ServiceException("保存失败，已存在项目名为" + bizProject.getProjectName() + "的项目");
        }
        if (bizProject.getId() == null) {
            bizProject.setCreateTime(new Date());
            this.baseMapper.insert(bizProject);
        } else {
            this.baseMapper.updateById(bizProject);
        }
    }

    @Override
    public void removeBizProject(BizProject bizProject) {
        BizProject project = this.baseMapper.selectById(bizProject.getId());
        if (project != null) {
            this.baseMapper.deleteById(bizProject.getId());
        } else {
            throw new ServiceException("删除失败，未获取到该项目信息");
        }
    }

    @Override
    public BizProjectVO getBizProject(BizProject bizProject) {
        BizProjectVO projectVO;
        if (bizProject.getId() != null) {
            projectVO = this.baseMapper.getProjectInfo(bizProject);
        } else {
            throw new ServiceException("获取该项目信息失败");
        }
        return projectVO;
    }

    @Override
    public Page<BizProjectVO> findBizProjectPage(Page<BizProjectVO> page, BizProject bizProject) {
        this.baseMapper.findProjectPage(page, bizProject);
        return page;
    }

    @Override
    public List<BizProject> findBizProjectList(BizProject bizProject) {
        //根据角色加载项目数据
        UserLoginInfo userInfo = CurrentUserUtil.getCurrentUser();
        SysUser user = userInfo.getUser();
        TaskFilterConditionDto filterConditionDto = new TaskFilterConditionDto();
//        //如果不是超级管理员
//        if(user.getUserType() != UserTypeEnum.admin.getCode()){
//            String position = userInfo.getPosition();
//            switch (PositionEnum.getEnumByCode(position)){
//                case Constructor:
//                    filterConditionDto.setConstructionEnterpriseId(userInfo.getEnterpriseId());break;
//                case Supervisor:
//                    filterConditionDto.setSupervisionEnterpriseId(userInfo.getEnterpriseId());break;
//                case Inspector:
//                    filterConditionDto.setConstructionEnterpriseId(userInfo.getEnterpriseId());break;
//                case Manager:
//                    BizEnterprise bizEnterprise = this.bizEnterpriseService.getById(userInfo.getEnterpriseId());
//                    if(bizEnterprise.getCategory().equals(EnterpriseCategoryEnum.owner.getCode())){
//                        filterConditionDto.setProjectEnterpriseId(userInfo.getEnterpriseId());
//                    }
//                    if(bizEnterprise.getCategory().equals(EnterpriseCategoryEnum.supervisor.getCode())){
//                        filterConditionDto.setSupervisionEnterpriseId(userInfo.getEnterpriseId());
//                    }
//                    if(bizEnterprise.getCategory().equals(EnterpriseCategoryEnum.construction.getCode())){
//                        filterConditionDto.setConstructionEnterpriseId(userInfo.getEnterpriseId());
//                    }
//                    break;
//                default: break;
//            }
//        }
        List<BizProject> projects = this.baseMapper.findBizProjectList(bizProject,filterConditionDto);
        return projects;
    }

    @Override
    public int getBizProjectSum(TaskFilterConditionDto conditionDto) {
        return this.baseMapper.getProjectNum(conditionDto);
    }

    public QueryWrapper<BizProject> getWrapper(BizProject bizProject) {
        QueryWrapper<BizProject> queryWrapper = new QueryWrapper<>();
        if (bizProject != null) {
            if (StringUtils.isNotEmpty(bizProject.getProjectName())) {
                queryWrapper.like("projectName", bizProject.getProjectName());
            }
            if (bizProject.getEnterpriseId() != null) {
                queryWrapper.eq("enterpriseId", bizProject.getEnterpriseId());
            }
        } else {
            throw new ServiceException("获取参数失败");
        }
        return queryWrapper;
    }
}
