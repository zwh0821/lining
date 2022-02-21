package com.isuperone.lining.service.inter.sys;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isuperone.lining.model.entity.sys.SysFaq;

import java.util.List;

/**
 * @program: Lining
 * @description:
 * @author: Joe
 * @create: 2020-06-14 19:46
 **/
public interface ISysFaqService extends IService<SysFaq> {

    int saveSysFaq(SysFaq sysFaq);

    int removeSysFaq(SysFaq sysFaq);

    Page<SysFaq> findSysFaqPage(Page<SysFaq> page, SysFaq sysFaq);

    List<SysFaq> findSysFaqList(SysFaq sysFaq);
}
