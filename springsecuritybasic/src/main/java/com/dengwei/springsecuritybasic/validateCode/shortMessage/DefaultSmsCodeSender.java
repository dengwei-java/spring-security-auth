package com.dengwei.springsecuritybasic.validateCode.shortMessage;

/**
 * @Author
 * @ClassName DefaultSmsCodeSender
 * @Description TODO  默认的短信验证码发送类
 * @Date 2019/7/2 23:45
 * @Version 1.0
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机" + mobile  + "发送验证码" + code);
    }


}
