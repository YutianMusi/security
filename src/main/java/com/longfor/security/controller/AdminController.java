package com.longfor.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gaoleijie.
 * @Description:
 * @Date:Created in 2018/8/26 0:29.
 */
@RestController
public class AdminController {
    @RequestMapping("/admin")
    public String selectTo(){
        return "只有admin访问权限";
    }
}
