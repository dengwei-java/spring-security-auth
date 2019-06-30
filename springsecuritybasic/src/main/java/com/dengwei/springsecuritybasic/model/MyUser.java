package com.dengwei.springsecuritybasic.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @Author
 * @ClassName MyUser
 * @Description TODO 自己的数据库用户类，实现springSecurity 提供的 UserDetails接口
 *
 * @Date 2019/6/24 22:40
 * @Version 1.0
 */
public class MyUser implements UserDetails {

    private String username;
    private String password;
    private List<Role> roles;

    /**
     * @Author
     * @Description //TODO 用户的所有权限 （封装用户的所有权限到List）
     * @Date 2019/6/24 22:49
     * @Param  * @param null
     * @return: List<new SimpleGrantedAuthority(String)>
     */
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roles.isEmpty() ? Collections.EMPTY_LIST :
//                (roles.parallelStream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList()));
//    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * @Author
     * @Description //TODO 用户的密码
     * @Date 2019/6/24 22:50
     * @Param  * @param null
     * @return
     */
    @Override
    public String getPassword() {
        return password;
    }
    /**
     * @Author
     * @Description //TODO 用户名
     * @Date 2019/6/24 22:50
     * @Param  * @param null
     * @return
     */
    @Override
    public String getUsername() {
        return username;
    }
  /**
   * @Author
   * @Description //TODO 账户是否过期（true表示没有过期）
   * @Date 2019/6/24 22:50
   * @Param  * @param null
   * @return
   */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * @Author
     * @Description //TODO 账户是否被锁定（true表示没有）
     * @Date 2019/6/24 22:51
     * @Param  * @param null
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * @Author
     * @Description //TODO 密码是否过期（true表示没有）
     * @Date 2019/6/24 22:52
     * @Param  * @param null
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * @Author
     * @Description //TODO 账户是否可用（true表示可用）
     * @Date 2019/6/24 22:52
     * @Param  * @param null
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
