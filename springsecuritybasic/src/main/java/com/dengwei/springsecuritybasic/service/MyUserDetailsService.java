package com.dengwei.springsecuritybasic.service;

import com.dengwei.springsecuritybasic.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Author
 * @ClassName MyUserDetailsService
 * @Description TODO  实现springSecurity提供的 UserDetailsService接口
 * 主要做封装用户信息
 * @Date 2019/6/24 22:42
 * @Version 1.0
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //根据用户名，查询当前登录用户的用户信息(这里我就不写sql查询了)
        MyUser myUser = new MyUser();
        myUser.setUsername("admin");
        myUser.setPassword(passwordEncoder.encode("123456"));
        return myUser;
    }


}
