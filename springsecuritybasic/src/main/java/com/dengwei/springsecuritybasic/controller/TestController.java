package com.dengwei.springsecuritybasic.controller;

import com.dengwei.springsecuritybasic.simple.SimpleMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author
 * @ClassName TestController
 * @Description TODO
 * @Date 2019/6/23 8:39
 * @Version 1.0
 */
@RestController
@RequestMapping("/my")
public class TestController {

   private RequestCache requestCache = new HttpSessionRequestCache();
   private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @RequestMapping(value = "/hello")
    public String test(){
        return "hello word!";
    }


    /**
     * @Author
     * @Description //TODO 当需要身份认证时，跳转到这里
     * @Date 2019/6/30 23:23
     * @Param  * @param null
     * @return
     */
    @RequestMapping("/myLogin")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public SimpleMessage login (HttpServletRequest request , HttpServletResponse response) throws IOException {
        //判断是后端处理登录跳转还是，返回json数据给前端，让前端收到消息后跳转
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if(null!=savedRequest){
            String redirectUrl = savedRequest.getRedirectUrl();
            if(StringUtils.endsWithIgnoreCase(redirectUrl,".html")){
                redirectStrategy.sendRedirect(request,response,"/login");
            }
        }
        return new SimpleMessage("当前用户需要身份认证");
    }
}
