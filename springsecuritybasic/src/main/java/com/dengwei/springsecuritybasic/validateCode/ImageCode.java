package com.dengwei.springsecuritybasic.validateCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @Author
 * @ClassName ImageCode
 * @Description TODO 图片验证码信息
 * @Date 2019/6/26 23:37
 * @Version 1.0
 */
public class ImageCode {

    private BufferedImage image; //图信息

    private String code;  //验证码

    private LocalDateTime expireTime;

    public  ImageCode(BufferedImage image,String code,int expireTime){
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireTime);
    }

    public  ImageCode(BufferedImage image,String code,LocalDateTime expireTime){
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }

    public  ImageCode(){}

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
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

    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }


}
