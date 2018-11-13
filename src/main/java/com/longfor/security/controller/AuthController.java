package com.longfor.security.controller;

import com.longfor.security.bean.User;
import com.longfor.security.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

/**
 * @Author: gaoleijie.
 * @Description:
 * @Date:Created in 2018/8/27 9:56.
 */
@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 操作结果
     * @throws AuthenticationException 错误信息
     */
    @PostMapping(value = "/auth/login", params = {"username", "password"})
    public String getToken(String username, String password) throws AuthenticationException {
        return authService.login(username, password);
    }

    /**
     * 用户注册
     *用户信息
     * @param user
     * @return 操作结果
     * @throws AuthenticationException 错误信息
     */
    @PostMapping(value = "/auth/register")
    public User register(User user) throws AuthenticationException {
        return authService.register(user);
    }

    /**
     * 刷新密钥
     *
     * @param authorization 原密钥
     * @return 新密钥
     * @throws AuthenticationException 错误信息
     */
    @GetMapping(value = "/auth/refreshToken")
    public String refreshToken(@RequestHeader String authorization) throws AuthenticationException {
        return authService.refresh(authorization);
    }

}
