package com.dengwei.springsecuritybasic.authentication;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author
 * @ClassName MyAuthenticationSuccessHandler
 * @Description TODO 登录成功处理器
 * 可以实现接口（AuthenticationSuccessHandler）
 * 也可以继承(SavedRequestAwareAuthenticationSuccessHandler) 建议继承
 * 如果不自定义登陆成功的处理springSecurity默认跳转用户访问的路径
 * @Date 2019/6/25 23:05
 * @Version 1.0
 */
@Component("MyAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(MyAuthenticationSuccessHandler.class);
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
 //    1:如果是前后端分离的请求格式则则将响应信息返回给浏览器，浏览器拿到json信息后做相应的处理
        logger.info("登陆成功");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(authentication));

// =============###############################========================================================
//     2: 如果不是前后端分离的话在后端直接跳转页面直接调用父类的方法即可
//      super.onAuthenticationSuccess(request,response,authentication);


    }
}
