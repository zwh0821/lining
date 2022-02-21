package com.isuperone.lining.service;

import com.isuperone.lining.model.entity.sys.SysUser;

import java.util.List;

/**
 * @program: Lining
 * @description: 用户service接口
 * @author: Joe
 * @create: 2020-03-27 15:47
 **/


public interface IUserService {


    List<SysUser> getAllUsers();

    SysUser getUserById(Long id);

    List<SysUser> getUsersByName(String name);

    Integer insertUser(SysUser sysUser);

    Integer updateUserById(SysUser sysUser);

    Integer deleteUserById(Integer id);
}
