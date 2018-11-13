package com.longfor.security.config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: gaoleijie.
 * @Description:如果用户已经通过身份验证，试图访问受保护的(该用户没有权限的)资源
 * @Date:Created in 2018/8/25 23:06.
 */
public class GoAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");
        httpServletResponse.getWriter().print("{\"code\":1,\"message\":\""+e.getMessage()+"\"}");
        httpServletResponse.getWriter().flush();

    }
}
