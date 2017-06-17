package com.water.controller;

import com.water.pojo.User;
import com.water.service.UserService;
import com.water.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by Water on 2017/6/17.
 * Email:water471871679@gmail.com
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/userById.action")
    private void findUserByid(HttpServletRequest req, HttpServletResponse rep)throws Exception{
        User user = userService.selectItemsById(1);
        LogUtils.info(user.toString());
        PrintWriter writer = rep.getWriter();
        writer.write(user.toString());
        writer.flush();
        writer.close();
    }
}
