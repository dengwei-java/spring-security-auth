package com.dengwei.springsecuritybasic.validateCode.shortMessage.mobile_anthenticaton;

import com.dengwei.springsecuritybasic.authentication.MyAuthenticationFailHandler;
import com.dengwei.springsecuritybasic.authentication.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * @Author
 * @ClassName SsmCodeAuthenticationSecurityConfig
 * @Description TODO
 * @Date 2019/7/4 23:02
 * @Version 1.0
 */
@Component
public class SsmCodeAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain,HttpSecurity> {

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailHandler myAuthenticationFailHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        ShortMessageAuthenticationFilter shortMessageAuthenticationFilter = new ShortMessageAuthenticationFilter();
        shortMessageAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        shortMessageAuthenticationFilter.setAuthenticationSuccessHandler(myAuthenticationSuccessHandler);
        shortMessageAuthenticationFilter.setAuthenticationFailureHandler(myAuthenticationFailHandler);

        ShortMessageAuthenticationProvider shortMessageAuthenticationProvider = new ShortMessageAuthenticationProvider();
        shortMessageAuthenticationProvider.setUserDetailsService(userDetailsService);

        http.authenticationProvider(shortMessageAuthenticationProvider)
            .addFilterAfter(shortMessageAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
    }
}
