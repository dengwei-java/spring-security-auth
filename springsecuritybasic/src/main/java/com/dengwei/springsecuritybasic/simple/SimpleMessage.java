package com.dengwei.springsecuritybasic.simple;

/**
 * @Author
 * @ClassName SimpleMessage
 * @Description TODO
 * @Date 2019/6/27 23:37
 * @Version 1.0
 */
public class SimpleMessage {
    private Object data;

    public SimpleMessage (Object data) {
        this.data = data;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
