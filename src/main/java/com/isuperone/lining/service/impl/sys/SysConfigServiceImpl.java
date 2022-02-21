package com.isuperone.lining.service.impl.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isuperone.lining.common.exception.ServiceException;
import com.isuperone.lining.mapper.sys.SysConfigMapper;
import com.isuperone.lining.model.entity.sys.SysConfig;
import com.isuperone.lining.service.inter.sys.ISysConfigService;
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
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements ISysConfigService {

    @Override
    public int saveSysConfig(SysConfig sysConfig) {
        QueryWrapper<SysConfig> ew = new QueryWrapper<>();
        if (sysConfig.getId() != null) {
            ew.ne("id", sysConfig.getId());
        }
        ew.eq("configKey", sysConfig.getConfigKey());
        List<SysConfig> query = this.baseMapper.selectList(ew);
        if (query.size() > 0) {
            throw new ServiceException(String.format("保存配置失败，已存在名为%s的配置项", sysConfig.getConfigKey()));
        }
        if (sysConfig.getId() == null) {
            sysConfig.setCreateTime(new Date());
            return this.baseMapper.insert(sysConfig);
        } else {
            return this.baseMapper.updateById(sysConfig);
        }
    }

    @Override
    public int removeSysConfig(SysConfig sysConfig) {
        SysConfig config = this.baseMapper.selectById(sysConfig.getId());
        if (config != null) {
            return this.baseMapper.deleteById(sysConfig.getId());
        } else {
            throw new ServiceException("未获取到该配置信息");
        }
    }

    @Override
    public Page<SysConfig> findSysConfigPage(Page<SysConfig> page, SysConfig sysConfig) {
        QueryWrapper<SysConfig> queryWrapper = this.getWrapper(sysConfig);
        this.baseMapper.selectPage(page, queryWrapper);
        return page;
    }

    @Override
    public List<SysConfig> findSysConfigList(SysConfig sysConfig) {
        QueryWrapper<SysConfig> queryWrapper = this.getWrapper(sysConfig);
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public SysConfig getConfigByConfigKey(String configKey) {
        if (StringUtils.isEmpty(configKey)) {
            throw new ServiceException("配置项不能为空");
        }
        SysConfig sysConfig = new SysConfig();
        sysConfig.setConfigKey(configKey);
        QueryWrapper<SysConfig> queryWrapper = this.getWrapper(sysConfig);
        return this.baseMapper.selectOne(queryWrapper);
    }

    public QueryWrapper<SysConfig> getWrapper(SysConfig sysConfig) {
        QueryWrapper<SysConfig> queryWrapper = new QueryWrapper<SysConfig>();
        if (sysConfig != null) {
            if (StringUtils.isNotEmpty(sysConfig.getDescription())) {
                queryWrapper.like("description", sysConfig.getDescription());
            }
            if (StringUtils.isNotEmpty(sysConfig.getConfigKey())) {
                queryWrapper.eq("configKey", sysConfig.getConfigKey());
            }
        } else {
            throw new ServiceException("获取参数失败");
        }
        return queryWrapper;
    }

}
