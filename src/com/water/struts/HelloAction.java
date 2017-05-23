package com.water.struts;

/**
 * Created by Water on 17/5/12.
 * Email:water471871679@gmail.com
 */
public class HelloAction {
    /**
     * 第一个Struts2方法
     */
    public String hello() {
        System.out.println("hello struts2");
        return "success";
    }
}
