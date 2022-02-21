package com.isuperone.lining.service.impl.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isuperone.lining.common.enumration.StatusEnums;
import com.isuperone.lining.common.exception.ServiceException;
import com.isuperone.lining.mapper.sys.SysModuleMapper;
import com.isuperone.lining.model.entity.sys.SysModule;
import com.isuperone.lining.model.vo.SysModuleVO;
import com.isuperone.lining.service.inter.sys.ISysModuleService;
import org.springframework.stereotype.Service;

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
public class SysModuleServiceImpl extends ServiceImpl<SysModuleMapper, SysModule> implements ISysModuleService {


    @Override
    public int saveModule(SysModule sysModule) throws Exception {

        QueryWrapper<SysModule> ew = new QueryWrapper<SysModule>();
        ew.eq("moduleName", sysModule.getModuleName());
        if (sysModule.getId() != null) {
            ew.ne("id", sysModule.getId());
        }
        List<SysModule> query = this.baseMapper.selectList(ew);
        if (query.size() > 0) {
            throw new Exception("已存在名为" + sysModule.getModuleName() + "菜单");
        }
        if (sysModule.getId() == null) {
            sysModule.setCreateTime(new Date());
            return this.baseMapper.insert(sysModule);
        }
        return baseMapper.updateById(sysModule);
    }

    @Override
    public void removeModule(SysModule sysModule) throws Exception {
        if (sysModule.getId() > 0) {
            SysModule module = this.baseMapper.selectById(sysModule.getId());
            QueryWrapper<SysModule> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("parentId", module.getId());
            queryWrapper.ne("status", StatusEnums.systemStatus_deleted.getCode());
            List<SysModule> queryList = this.baseMapper.selectList(queryWrapper);
            if (queryList != null && queryList.size() > 0) {
                throw new ServiceException("当前模块存在下级菜单，不能删除，请删除下级菜单之后再进行操作");
            }
            module.setStatus(StatusEnums.systemStatus_deleted.getCode());
            QueryWrapper<SysModule> wrapper = new QueryWrapper<>();
            module.setStatus(StatusEnums.systemStatus_deleted.getCode());
            wrapper.eq("id", sysModule.getId());
            this.baseMapper.update(module, wrapper);

        } else {
            throw new ServiceException("获取菜单主键Id");
        }
    }

    @Override
    public Page<SysModule> findModulePage(Page<SysModule> page, SysModule sysModule) {
        QueryWrapper<SysModule> queryWrapper = this.getWrapper(sysModule);
        this.baseMapper.selectPage(page, queryWrapper);
        return page;
    }

    @Override
    public Page<SysModuleVO> findMenuPage(Page<SysModuleVO> page, SysModule sysModule) {
        this.baseMapper.findMenuPage(page, sysModule);
        return page;
    }

    @Override
    public List<SysModule> findModuleList(SysModule sysModule) {
        QueryWrapper<SysModule> queryWrapper = this.getWrapper(sysModule);
        queryWrapper.orderByAsc("sort");
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public SysModuleVO getMenu(SysModule sysModule) {
        return this.baseMapper.getMenu(sysModule);
    }

    public QueryWrapper<SysModule> getWrapper(SysModule sysModule) {
        QueryWrapper<SysModule> queryWrapper = new QueryWrapper<SysModule>();
        if (sysModule != null) {
            if (StringUtils.isNotEmpty(sysModule.getModuleName())) {
                queryWrapper.like("name", sysModule.getModuleName());
            }
            if (StringUtils.isNotEmpty(sysModule.getDescription())) {
                queryWrapper.like("description", sysModule.getDescription());
            }
            if (sysModule.getGrade() != null) {
                queryWrapper.eq("grade", sysModule.getGrade());
            }
            if (sysModule.getStatus() != null) {
                queryWrapper.eq("status", sysModule.getStatus());
            } else {
                queryWrapper.ne("status", StatusEnums.systemStatus_deleted.getCode());
            }
            if(sysModule.getMenu() != null){
                queryWrapper.eq("isMenu", sysModule.getMenu());
            }
        }
        return queryWrapper;
    }
}
