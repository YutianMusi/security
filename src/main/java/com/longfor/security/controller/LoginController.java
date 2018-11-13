package com.longfor.security.controller;

import com.longfor.security.bean.Res;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: gaoleijie.
 * @Description:
 * @Date:Created in 2018/8/26 1:40.
 */
@Controller
@Slf4j
public class LoginController {
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @RequestMapping(value = "/login")
    public String login() {
        log.info("##################################跳转到登陆界面");
        return "login";
    }
    /**
     * 用户登陆验证
     */
    @RequestMapping("/index")
    public String index(Model model) {
        log.info("##################################跳转到主界面");
        Res msg = new Res("标题", "内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "index";
    }

}
