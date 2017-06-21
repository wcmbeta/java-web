package com.water.utils;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Water on 2017/6/20.
 * Email:water471871679@gmail.com
 */
public class Utils {
    public static void setResponse(HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");//防止数据传递乱码
        response.setHeader("Content-type", "text/json;charset=UTF-8");
    }
}
