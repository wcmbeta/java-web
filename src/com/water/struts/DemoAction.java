package com.water.struts;

import com.opensymphony.xwork2.Action;

/**
 * 实现一个接口Action,不常用
 * Created by Water on 17/5/15.
 * Email:water471871679@gmail.com
 */
public class DemoAction implements Action {
    //提供一个规范
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
