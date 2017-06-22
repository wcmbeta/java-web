package com.water.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Water on 2017/6/22.
 * Email:water471871679@gmail.com
 */
@Controller
public class BaseController {
    @RequestMapping("*")
    private ModelAndView error404()throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", "404-找不到页面");
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
