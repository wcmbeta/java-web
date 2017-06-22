package com.water.exception;

/**
 * Created by Water on 2017/6/22.
 * Email:water471871679@gmail.com
 */
public class MessageException extends Exception {
    private String msg;

    public MessageException(String msg) {
        super();
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
