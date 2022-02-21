package com.isuperone.lining.common.helper;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.isuperone.lining.model.bean.PublicKeyParamBean;

import java.util.HashMap;

/**
 * @program: WebSocket
 * @description: 第三方平台工具类
 * @author: Joe
 * @create: 2020-12-01 17:54
 **/
public class ThirdPartHelper {

    public static String getToken() {
        //step 1 获取公钥
        String publiKeyUrl = "http://47.106.222.151:50007/ftk/api/identity-server/clients/public-key";
        PublicKeyParamBean publicKeyParamBean = new PublicKeyParamBean();
        publicKeyParamBean.setClientId("TL_App");
        publicKeyParamBean.setVersion(1);
        String jsonstr = JSONUtil.toJsonStr(publicKeyParamBean);
        String response = HttpClientUtil.doPostJson(publiKeyUrl, jsonstr);
        JSONObject jsonObject = JSONUtil.parseObj(response);
        String publicKey = jsonObject.get("publicKey").toString();
        //step 2 获取令牌
        String tokenUrl = "http://47.106.222.151:50007/ftk/connect/token";
        HashMap<String, String> paramMap2 = new HashMap<>();
        paramMap2.put("version", "1");
        paramMap2.put("client_id", "TL_App");
        paramMap2.put("grant_type", "password");
        paramMap2.put("username", "uploadhh6");
        paramMap2.put("password", "Uploadhh6*");
        String response2 = HttpClientUtil.doPost(tokenUrl, paramMap2);
        JSONObject jsonObject2 = JSONUtil.parseObj(response2);
        String token = jsonObject2.get("access_token").toString();
        return token;
    }

}
