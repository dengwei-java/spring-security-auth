package com.dengwei.springsecuritybasic.controller;

import com.dengwei.springsecuritybasic.utils.CreateImageCodeUtil;
import com.dengwei.springsecuritybasic.validateCode.ImageCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author
 * @ClassName VolidateCodeController
 * @Description TODO 图片验证码controller
 * @Date 2019/6/26 23:55
 * @Version 1.0
 */
@RestController
public class ValidateCodeController {

    @GetMapping("/image/code")
    public  void getImageCode(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //生成图片验证码
        ImageCode imageCode = CreateImageCodeUtil.createImageCode();
        HttpSession session = req.getSession();
        session.setAttribute("imageCode",imageCode);
        ImageIO.write(imageCode.getImage(),"JPEG",res.getOutputStream());

    }




}
