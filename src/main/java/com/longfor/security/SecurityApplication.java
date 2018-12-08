package com.longfor.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.longfor.security.daversiono")
@EnableAspectJAutoProxy
public class SecurityApplication {
    //开始启动项目
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
}
