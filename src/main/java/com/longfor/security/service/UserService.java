package com.longfor.security.service;

import com.longfor.security.bean.User;
import com.longfor.security.dao.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author: gaoleijie.
 * @Description:
 * @Date:Created in 2018/8/23 18:25.
 */
@Service
public class UserService implements  UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user =userMapper.selectUserByUsername(s);
        if(null == user){
            throw new UsernameNotFoundException(String.format("未找到名字为'%s'.",s));
        }
        return user;
    }
}
