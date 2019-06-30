package com.dengwei.springsecuritybasic.config;

import com.dengwei.springsecuritybasic.authentication.MyAuthenticationFailHandler;
import com.dengwei.springsecuritybasic.authentication.MyAuthenticationSuccessHandler;
import com.dengwei.springsecuritybasic.filter.ValidateCodeFilter;
import com.dengwei.springsecuritybasic.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @Author
 * @ClassName SecurityConfig
 * @Description TODO
 * @Date 2019/6/23 8:38
 * @Version 1.0
 */
@Configuration
@EnableGlobalMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailHandler myAuthenticationFailHandler;
    @Autowired
    private ValidateCodeFilter validateCodeFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic() //basic 方式验证
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class) //添加验证码过滤器在用户名密码过滤器之前
                .formLogin() //表单验证
    //              .loginPage("/login") //请求的controller
                    .loginPage("/login.html") //指定登录页面
                    .loginProcessingUrl("/login") //自定义表单登陆提交的action
    //              .successForwardUrl("/my/hello") //设置登录请求的url路径
    //              .defaultSuccessUrl("/my/hello")  //登陆成功跳转的路径
                    .successHandler(myAuthenticationSuccessHandler)  //添加登陆成功过滤器的处理
                    .failureHandler(myAuthenticationFailHandler)   //添加登陆失败过滤器的处理
                .and()
                   .rememberMe()   //添加记住我功能
                   .tokenRepository(persistentTokenRepository())
                   .tokenValiditySeconds(3600) //token有效时间（秒）
                   .userDetailsService(myUserDetailsService) //获取到用户名做登陆
                .and()
                    .authorizeRequests()
                    .antMatchers("/login.html", "/image/code","/favicon.ico").permitAll() //访问登录页面不做拦截（允许访问）
                    .anyRequest()
                    .authenticated()
                .and()
                    .csrf()
                    .disable();
    }


    /**
     * @return
     * @Author
     * @Description //TODO 主要对于用户的密码加密处理
     * //TODO springSecurity提供的PasswordEncoder中的 encode（做加密） matches（做密码匹配）
     * 所以这里新建用户或用户注册时的加密方式要一样，数据库的密码和用户在表单输入的密码做匹配
     * 如果需要自定义加密方式，实现PasswordEncoder接口 重写encode方法即可
     * @Date 2019/6/24 23:17
     * @Param * @param null
     */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * @Author
     * @Description //TODO 添加记住我的功能
     *
     * @Date 2019/6/30 22:16
     * @Param  * @param null
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //启动时创建表(首次启动时需要)
//        jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }
}
