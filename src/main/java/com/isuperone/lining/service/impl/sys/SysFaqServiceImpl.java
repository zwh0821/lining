package com.isuperone.lining.service.impl.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isuperone.lining.common.exception.ServiceException;
import com.isuperone.lining.mapper.sys.SysFaqMapper;
import com.isuperone.lining.model.entity.sys.SysFaq;
import com.isuperone.lining.service.inter.sys.ISysFaqService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: Lining
 * @description:
 * @author: Joe
 * @create: 2020-06-14 19:48
 **/
@Service
public class SysFaqServiceImpl extends ServiceImpl<SysFaqMapper, SysFaq> implements ISysFaqService {
    @Override
    public int saveSysFaq(SysFaq sysFaq) {

        QueryWrapper<SysFaq> ew = new QueryWrapper<>();
        if (sysFaq.getId() != null) {
            ew.ne("id", sysFaq.getId());
        }
        ew.eq("question",sysFaq.getQuestion());
        List<SysFaq> query = this.baseMapper.selectList(ew);
        if (query.size() > 0) {
            String message = String.format("保存帮助文档失败，已存在名为%s的帮助文档", sysFaq.getQuestion());
            throw new ServiceException(message);
        }
        if (sysFaq.getId() == null) {
            sysFaq.setCreateDate(new Date());
            return this.baseMapper.insert(sysFaq);
        } else {
            return this.baseMapper.updateById(sysFaq);
        }
    }

    @Override
    public int removeSysFaq(SysFaq sysFaq) {
        SysFaq faq = this.baseMapper.selectById(sysFaq.getId());
        if (faq != null) {
            return this.baseMapper.deleteById(sysFaq.getId());
        } else {
            throw new ServiceException("未获取到该帮助文档信息");
        }
    }

    @Override
    public Page<SysFaq> findSysFaqPage(Page<SysFaq> page, SysFaq sysFaq) {
        QueryWrapper<SysFaq> queryWrapper = this.getWrapper(sysFaq);
        this.baseMapper.selectPage(page, queryWrapper);
        return page;
    }

    @Override
    public List<SysFaq> findSysFaqList(SysFaq sysFaq) {
        QueryWrapper<SysFaq> queryWrapper = this.getWrapper(sysFaq);
        return this.baseMapper.selectList(queryWrapper);
    }

    public QueryWrapper<SysFaq> getWrapper(SysFaq sysFaq) {
        QueryWrapper<SysFaq> queryWrapper = new QueryWrapper<SysFaq>();
        if (sysFaq != null) {
            if (StringUtils.isNotEmpty(sysFaq.getQuestion())) {
                queryWrapper.like("question", sysFaq.getQuestion());
            }
        } else {
            throw new ServiceException("获取参数失败");
        }
        return queryWrapper;
    }
}
