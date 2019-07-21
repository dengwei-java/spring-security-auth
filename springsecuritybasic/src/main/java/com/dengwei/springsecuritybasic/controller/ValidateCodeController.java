package com.dengwei.springsecuritybasic.controller;

import com.dengwei.springsecuritybasic.validateCode.ValidateCode;
import com.dengwei.springsecuritybasic.validateCode.ValidateCodeGenerator;
import com.dengwei.springsecuritybasic.validateCode.image.ImageCode;
import com.dengwei.springsecuritybasic.validateCode.shortMessage.DefaultSmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author
 * @ClassName VolidateCodeController
 * @Description TODO 图片验证码/短信验证码controller
 * @Date 2019/6/26 23:55
 * @Version 1.0
 */
@RestController
public class ValidateCodeController {

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;  //图形验证码接口

    @Autowired
    private ValidateCodeGenerator smsCodeGenerator;  //短信验证码接口
    /**
     * @Author
     * @Description //TODO 获取图形验证码
     * @Date 2019/7/2 22:32
     * @Param  * @param null
     * @return
     */
    @GetMapping("/image/code")
    public  void getImageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //生成图片验证码
        ImageCode imageCode = (ImageCode)imageCodeGenerator.generate(request);
        //把生成的图形验证码放入session中
        request.getSession().setAttribute("imageCode",imageCode);
        ImageIO.write(imageCode.getImage(),"JPEG",response.getOutputStream());

    }
    /**
     * @Author
     * @Description //TODO 获取短信验证码(short Message )
     * @Date 2019/7/2 22:32
     * @Param  * @param null
     * @return
     */
    @GetMapping("/mobile/code/{mobile}")
    public  void getSmsCode(HttpServletRequest request, @PathVariable String mobile) throws IOException {
        //生成短信验证码
        ValidateCode smsCode = smsCodeGenerator.generate(request);
        //将短信验证码放入到session中
        request.getSession().setAttribute("mobileCode",smsCode);
        //通过短信服务提供商发送短信
       new DefaultSmsCodeSender().send(mobile,"1234");

    }


}
