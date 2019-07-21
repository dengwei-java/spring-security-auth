package com.dengwei.springsecuritybasic.validateCode;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author
 * @Description //TODO 定义公共的验证码接口（图片验证码、短信验证码。。。实现该接口即可）
 * @Date 2019/7/2 23:29
 */
public interface ValidateCodeGenerator {

    ValidateCode generate(HttpServletRequest request);

}
