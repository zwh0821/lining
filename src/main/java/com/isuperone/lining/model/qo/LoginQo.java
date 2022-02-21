package com.isuperone.lining.model.qo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 登陆请求参数
 */
public class LoginQo {

    @NotBlank(message = "用户账号不能为空")
    public String username;

    @NotBlank(message = "用户密码不能为空")
    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
