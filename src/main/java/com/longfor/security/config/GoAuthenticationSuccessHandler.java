package com.longfor.security.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: gaoleijie.
 * @Description:用于处理一个成功的身份验证实现执行是处理导航到后续的目标.
 * @Date:Created in 2018/8/25 22:57.
 */
public class GoAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");
        httpServletResponse.getWriter().print("{\"code\":0,\"message\":\"登录成功\"}");
        httpServletResponse.getWriter().flush();

    }
}
