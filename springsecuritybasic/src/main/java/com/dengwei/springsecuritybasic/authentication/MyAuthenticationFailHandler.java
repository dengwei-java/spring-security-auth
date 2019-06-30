package com.dengwei.springsecuritybasic.authentication;

import com.alibaba.fastjson.JSON;
import com.dengwei.springsecuritybasic.simple.SimpleMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author
 * @ClassName MyAuthenticationFailHadler
 * @Description TODO 登陆失败处理器
 * 可以实现接口（AuthenticationFailureHandler）
 * 也可以继承(SimpleUrlAuthenticationFailureHandler) 建议继承
 * @Date 2019/6/25 23:18
 * @Version 1.0
 */
@Component("MyAuthenticationFailHandler")
public class MyAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

//    1:如果是前后端分离的请求格式则则将响应信息返回给浏览器，浏览器拿到json信息后做相应的处理
            logger.info("登录失败");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value()); //设置响应状态500
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString(new SimpleMessage(exception.getMessage()))); //返回错误消息



// =============############不是前后端分离###################========================================================
//     2: 如果不是前后端分离的话在后端直接跳转页面直接调用父类的方法即可
//       super.onAuthenticationFailure(request,response,exception);
    }


}
