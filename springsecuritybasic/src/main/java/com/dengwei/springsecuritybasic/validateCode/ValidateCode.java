package com.dengwei.springsecuritybasic.validateCode;

import java.time.LocalDateTime;

/**
 * @Author
 * @ClassName ValidateCode 验证码基类
 * @Description TODO
 * @Date 2019/7/2 22:57
 * @Version 1.0
 */
public class ValidateCode {

    private String code;

    private LocalDateTime expireTime;

    public ValidateCode(String code, int expireIn){
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ValidateCode(String code, LocalDateTime expireTime){
        this.code = code;
        this.expireTime = expireTime;
    }

    /**
     * @Author
     * @Description //TODO 验证码是否过期
     * 返回true表示已过期
     * @Date 2019/7/2 22:58
     * @Param  * @param null
     * @return
     */
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }

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
