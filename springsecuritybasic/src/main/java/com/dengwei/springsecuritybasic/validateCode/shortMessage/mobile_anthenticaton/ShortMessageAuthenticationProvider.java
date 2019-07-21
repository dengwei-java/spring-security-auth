package com.dengwei.springsecuritybasic.validateCode.shortMessage.mobile_anthenticaton;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Author
 * @ClassName ShortMessageAuthenticationProvider
 * @Description TODO 自定义短信验证码登录的认证逻辑
 * @Date 2019/7/4 22:25
 * @Version 1.0
 */
public class ShortMessageAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ShortMessageCodeAuthenticationToken authenticationToken = (ShortMessageCodeAuthenticationToken) authentication;
        UserDetails user = userDetailsService.loadUserByUsername((String) authenticationToken.getPrincipal());
        if(null ==user){
            throw new InternalAuthenticationServiceException("无法获取用户信息");
        }

        ShortMessageCodeAuthenticationToken authenticationResult= new ShortMessageCodeAuthenticationToken(user, user.getAuthorities());
        authenticationResult.setDetails(authenticationToken);

        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> authenticate) {
        //判断当前传经来的类是否是ShortMessageCodeAuthenticationToken
        // 如果是就会调用 ShortMessageAuthenticationProvider来处理相关的验证逻辑
        return ShortMessageCodeAuthenticationToken.class.isAssignableFrom(authenticate);
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
