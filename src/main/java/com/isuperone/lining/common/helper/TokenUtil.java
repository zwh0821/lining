package com.isuperone.lining.common.helper;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.isuperone.lining.model.entity.sys.SysUser;

/**
 * @program: Lining
 * @description: jwt工具类
 * @author: Joe
 * @create: 2020-06-01 11:29
 **/
public class TokenUtil {

    public static String getToken(SysUser user) {
        String token="";
        token= JWT.create().withAudience(user.getId().toString())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

}
