package com.dengwei.springsecuritybasic.enummeration;

/**
 * @Author
 * @ClassName ResponseCode
 * @Description TODO
 * @Date 2019/6/25 22:09
 * @Version 1.0
 */
public enum ResponseCode {
    success(200,"成功"),
    error(500,"失败");


    private Integer code;
    private String message;
    private ResponseCode (int code,String message) {
        this.code = code;
        this.message = message;
    }

    public String getValue (int key){
        for(ResponseCode responseCode : ResponseCode.values()){
            if(responseCode.code == key){
               return responseCode.getMessage();
            }
        }
        return null;
    }
    public Integer getkey (String value){
        for(ResponseCode responseCode : ResponseCode.values()){
            if(responseCode.message.equals(value)){
                return responseCode.getCode();
            }
        }
        return null;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
