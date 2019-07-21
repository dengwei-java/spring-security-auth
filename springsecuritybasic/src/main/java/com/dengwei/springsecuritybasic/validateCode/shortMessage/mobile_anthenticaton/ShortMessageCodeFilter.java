package com.dengwei.springsecuritybasic.validateCode.shortMessage.mobile_anthenticaton;


import com.dengwei.springsecuritybasic.authentication.MyAuthenticationFailHandler;
import com.dengwei.springsecuritybasic.authenticationException.ValidateCodeException;
import com.dengwei.springsecuritybasic.validateCode.ValidateCode;
import com.dengwei.springsecuritybasic.validateCode.image.ImageCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author
 * @ClassName ValidateCodeFilter
 * @Description TODO 自定义验证码过滤器
 * 继承 spring提供的 OncePerRequestFilter 保证我们的过滤器每次只调用一次
 * @Date 2019/6/27 22:29
 * @Version 1.0
 */
@Component
public class ShortMessageCodeFilter extends OncePerRequestFilter {

    @Autowired
    private MyAuthenticationFailHandler myAuthenticationFailHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        //如果是登录请求，表单登录地址是（/authentication/mobile） 并且是post请求
        if(StringUtils.equals("/authentication/mobile",request.getRequestURI())
                && StringUtils.equalsIgnoreCase(request.getMethod(),"post")){

            try{
                //验证码验证
              validate(request);
            }catch (ValidateCodeException e){
                myAuthenticationFailHandler.onAuthenticationFailure(request,response,e);
                return;
            }

        }else {
            //如果不是登录请求继续走后面的过滤器
            filterChain.doFilter(request,response);
        }

    }

    /**
     * @Author
     * @Description //TODO 验证码验证是否正确
     * @Date 2019/6/27 23:27
     * @Param  * @param null
     * @return
     */
    private void validate(HttpServletRequest request){
        ValidateCode imageCodeSession = (ValidateCode) request.getSession().getAttribute("mobileCode");
        String imageCodeWeb = request.getParameter("mobileCode");

        if(StringUtils.isBlank(imageCodeWeb)){
            throw new ValidateCodeException("验证码的值不能为空");
        }
        if(null==imageCodeSession){
            throw new ValidateCodeException("验证码不存在");
        }
        if(imageCodeSession.isExpried()){
            throw new ValidateCodeException("验证码已过期");
        }
        if(!StringUtils.equalsIgnoreCase(imageCodeSession.getCode(),imageCodeWeb)){
            throw new ValidateCodeException("请输入正确的验证码");
        }

        request.getSession().removeAttribute("mobileCode");

    }



}
