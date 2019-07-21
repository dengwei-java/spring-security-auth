package com.dengwei.springsecuritybasic.validateCode.shortMessage;

import com.dengwei.springsecuritybasic.validateCode.ValidateCode;
import com.dengwei.springsecuritybasic.validateCode.ValidateCodeGenerator;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author
 * @ClassName SmsCodeGenerator
 * @Description TODO 短信验证码生成器
 * @Date 2019/7/2 23:37
 * @Version 1.0
 */
@Component
public class SmsCodeGenerator implements ValidateCodeGenerator {


    @Override
    public ValidateCode generate(HttpServletRequest request) {
        return new ValidateCode("1234",888888888);
    }
}
