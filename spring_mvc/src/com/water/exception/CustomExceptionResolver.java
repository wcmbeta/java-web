package com.water.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 * Created by Water on 2017/6/22.
 * Email:water471871679@gmail.com
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                         //Object发生源
                                         Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof MessageException) {
            modelAndView.addObject("error", ((MessageException) e).getMsg());
        }else {
            modelAndView.addObject("error", "未知异常");
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
