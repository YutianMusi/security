package com.longfor.security.service;

import com.longfor.security.bean.User;

/**
 * @Author: gaoleijie.
 * @Description:
 * @Date:Created in 2018/8/27 9:38.
 */
public interface AuthService {
    User register(User user);
    String login(String username, String password);
    String refresh(String oldToken);
}
