package com.longfor.security.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: gaoleijie.
 * @Description:它负责启动未经过身份验证的用户的身份验证过程(当他们试图访问受保护的资源
 * @Date:Created in 2018/8/25 23:11.
 */
public class GoAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");
        httpServletResponse.getWriter().print("{\"code\":1,\"message\":\""+e.getMessage()+"\"}");
        httpServletResponse.getWriter().flush();

    }
}
