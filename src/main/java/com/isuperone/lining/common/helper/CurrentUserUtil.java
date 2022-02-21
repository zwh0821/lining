package com.isuperone.lining.common.helper;

import com.isuperone.lining.model.dto.basis.UserLoginInfo;
import com.isuperone.lining.model.entity.sys.SysUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: Lining
 * @description: 获取当前用户信息
 * @author: Joe
 * @create: 2020-06-01 12:06
 **/
public class CurrentUserUtil {

    public static UserLoginInfo getCurrentUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        UserLoginInfo user = (UserLoginInfo)request.getAttribute("user");
        return user;
    }

}
