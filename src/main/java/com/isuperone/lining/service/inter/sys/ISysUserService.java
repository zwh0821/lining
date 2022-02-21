package com.isuperone.lining.service.inter.sys;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isuperone.lining.model.dto.LoginDto;
import com.isuperone.lining.model.dto.basis.AppLoginVO;
import com.isuperone.lining.model.dto.basis.UserInfo;
import com.isuperone.lining.model.dto.basis.UserPositionInfoDto;
import com.isuperone.lining.model.entity.sys.SysRole;
import com.isuperone.lining.model.entity.sys.SysUser;
import com.isuperone.lining.model.qo.LoginQo;
import com.isuperone.lining.model.vo.SysUserVO;
import org.apache.ibatis.annotations.Param;


/**
 * @program: Lining
 * @description: 用户service接口
 * @author: Joe
 * @create: 2020-03-27 15:47
 **/


public interface ISysUserService  extends IService<SysUser> {

     LoginDto login(LoginQo para) throws Exception;

     void saveUser(SysUserVO sysUserVO) throws Exception;

     Page<SysUserVO> findUserPage(Page<SysUserVO> page,SysUser sysUser);

     SysUserVO getUserInfo(SysUserVO sysUserVO);

     void removeUser(SysUserVO sysUserVo);

     UserPositionInfoDto getPositonInfo(Long userId);

     UserInfo userLoginInfo();

     AppLoginVO appLogin(LoginQo para) throws Exception;
}
