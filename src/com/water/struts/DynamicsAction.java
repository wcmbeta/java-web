package com.water.struts;

/**
 * 动态方法调用
 * Created by Water on 17/5/15.
 * Email:water471871679@gmail.com
 */
public class DynamicsAction {
    public String add() {
        System.out.println("add");
        return "success";
    }
    public String delete() {
        System.out.println("delete");
        return "success";
    }
}
