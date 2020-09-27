package com.spring1024.config;

import org.apache.shiro.authc.UsernamePasswordToken;

public class myToken extends UsernamePasswordToken {
    private String loginType;
    public myToken(String lname, char[] chars, String landlord) {}

    public myToken(final String loginName, final String password,
                     final String loginType) {
        super(loginName, password);
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}
