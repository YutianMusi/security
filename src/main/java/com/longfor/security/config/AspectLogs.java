package com.longfor.security.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: gaoleijie.
 * @Description:切面日志管理
 * @Date:Created in 2018/8/26 19:03.
 */
@Aspect
@Component
@Slf4j
public class AspectLogs {


    ThreadLocal<Long> startTime = new ThreadLocal();

    @Pointcut("execution(public * com.longfor.security.controller.*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        log.info("请求URL : " + request.getRequestURL().toString());
        log.info("请求方式HTTP_METHOD : " + request.getMethod());
        log.info("IP地址 : " + request.getRemoteAddr());
        log.info("设计类CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("参数ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        //处理完返回内容
        log.info("返回RESPONSE : " + ret);
        log.info("时间SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
    }

}
