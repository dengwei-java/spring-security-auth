package com.dengwei.springsecuritybasic.validateCode.shortMessage;

/**
 * @Author
 * @ClassName SmsCodeSender
 * @Description TODO 短行验证发送的接口
 * @Date 2019/7/2 23:40
 * @Version 1.0
 */
public interface SmsCodeSender {

    /**
     * @Author
     * @Description //TODO 发送短信验证码
     * @Date 2019/7/2 23:42
     * @Param  mobile ：验证码发送给谁？（手机号）
     * @param code ：验证码
     * @return
     */
    public void send(String mobile,String code);


}
