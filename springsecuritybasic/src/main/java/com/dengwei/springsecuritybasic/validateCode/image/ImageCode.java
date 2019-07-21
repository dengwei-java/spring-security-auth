package com.dengwei.springsecuritybasic.validateCode.image;

import com.dengwei.springsecuritybasic.validateCode.ValidateCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @Author
 * @ClassName ImageCode
 * @Description TODO 图片验证码信息
 * @Date 2019/6/26 23:37
 * @Version 1.0
 */
public class ImageCode extends ValidateCode {

    private BufferedImage image; //图信息


    public  ImageCode(BufferedImage image,String code,int expireTime){
        super(code,expireTime);
        this.image = image;
    }

    public  ImageCode(BufferedImage image,String code,LocalDateTime expireTime){
        super(code,expireTime);
        this.image = image;
    }


    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }





}
