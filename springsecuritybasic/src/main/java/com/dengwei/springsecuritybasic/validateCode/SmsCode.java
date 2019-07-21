package com.dengwei.springsecuritybasic.validateCode;

import java.time.LocalDateTime;

/**
 * @Author
 * @ClassName SmsCode
 * @Description TODO 短行验证码信息对象
 * @Date 2019/7/2 22:35
 * @Version 1.0
 */
public class SmsCode {

    private String code; //短信验证码

    private LocalDateTime expireTime; // 验证码过期时间


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
