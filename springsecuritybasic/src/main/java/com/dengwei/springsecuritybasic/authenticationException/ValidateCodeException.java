package com.dengwei.springsecuritybasic.authenticationException;


import org.springframework.security.core.AuthenticationException;

/**
 * @Author
 * @ClassName ValidateCodeException
 * @Description TODO 自定义验证码验证失败时抛出异常
 * @Date 2019/6/27 22:42
 * @Version 1.0
 */
public class ValidateCodeException extends AuthenticationException {


    public ValidateCodeException(String msg) {
        super(msg);
    }


}
