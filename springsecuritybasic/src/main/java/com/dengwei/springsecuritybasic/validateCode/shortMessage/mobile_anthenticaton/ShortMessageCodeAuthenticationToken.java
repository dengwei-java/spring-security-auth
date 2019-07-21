package com.dengwei.springsecuritybasic.validateCode.shortMessage.mobile_anthenticaton;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @Author
 * @ClassName ShortMessageCodeAuthenticationToken
 * @Description TODO 自定义短行验证，第一步：创建Authentication实例(参考springSecurity的UserNamePasswordAuthenticationToken创建)
 * 这里参考全局搜索（ctrl+shit+N）
 * 自定义ShortMessageCodeAuthenticationToken 类 继承 AbstractAuthenticationToken
 * @Date 2019/7/4 21:26
 * @Version 1.0
 */
public class ShortMessageCodeAuthenticationToken extends AbstractAuthenticationToken  {

    private static final long serialVersionUID = 420L;
    private final Object principal;


    public ShortMessageCodeAuthenticationToken(String mobile) {
        super(null);
        this.principal = mobile;
        this.setAuthenticated(false);
    }

    public ShortMessageCodeAuthenticationToken(Object principal,Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        super.setAuthenticated(true);
    }


    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        } else {
            super.setAuthenticated(false);
        }
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
    }


    public Object getCredentials() {
        return null;
    }


    public Object getPrincipal() {
        return this.principal;
    }
}
