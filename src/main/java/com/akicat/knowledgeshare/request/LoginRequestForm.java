package com.akicat.knowledgeshare.request;

import javax.validation.constraints.NotBlank;

public class LoginRequestForm {
    @NotBlank(message = "用户名不能为空。")
    private String userName;
    // 密码
    @NotBlank(message = "密码不能为空。")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
