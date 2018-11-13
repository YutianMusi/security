package com.longfor.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: gaoleijie.
 * @Description:
 * @Date:Created in 2018/8/23 18:20.
 */
@RestController
@Slf4j
public class UserController {
    @RequestMapping("/user")
    public String user() {
        return "普通用户访问";
    }


}
