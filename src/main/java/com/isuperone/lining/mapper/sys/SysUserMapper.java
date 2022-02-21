package com.isuperone.lining.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isuperone.lining.model.dto.basis.UserPositionInfoDto;
import com.isuperone.lining.model.entity.sys.SysUser;
import com.isuperone.lining.model.vo.SysUserVO;
import org.apache.ibatis.annotations.Param;

/**
 * @program: Lining
 * @description: SysUserMapper
 * @author: Joe
 * @create: 2020-03-27 15:32
 **/
public interface SysUserMapper extends BaseMapper<SysUser> {

    Page<SysUserVO> findUserPage(Page<SysUserVO> page, @Param("sysUser") SysUser sysUser);

    SysUserVO getUserInfo(@Param("sysUser") SysUserVO sysUserVO);

    UserPositionInfoDto getPositonInfo(@Param("userId")Long userId);
}
