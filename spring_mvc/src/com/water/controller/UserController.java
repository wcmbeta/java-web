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
import java.util.List;

/**
 * Created by Water on 2017/6/17.
 * Email:water471871679@gmail.com
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userById.action")
    private void findUserByid(HttpServletRequest req, HttpServletResponse rep) throws Exception {
        rep.setCharacterEncoding("UTF-8");
        rep.setContentType("application/json;charset=UTF-8");//防止数据传递乱码
        rep.setHeader("Content-type", "text/json;charset=UTF-8");
        User user = userService.selectUserById(1);


        LogUtils.info(user.toString());


        PrintWriter writer = rep.getWriter();
        writer.write(user.toString());
        writer.flush();
        writer.close();
    }

    @RequestMapping("/userByUsername.action")
    private void findUserByUsername(HttpServletRequest req, HttpServletResponse rep) throws Exception {
        rep.setCharacterEncoding("UTF-8");
        rep.setContentType("application/json;charset=UTF-8");//防止数据传递乱码
        rep.setHeader("Content-type", "text/json;charset=UTF-8");
        List<User> list = userService.selectUsersByName("王");
        User user = null;
        if (null != list && !list.isEmpty()) {
            user = list.get(0);
        }


        PrintWriter writer = rep.getWriter();
        if (user != null) {
            writer.write(user.toString());
            LogUtils.info(user.toString());
        } else {
            writer.write("查询失败");
            LogUtils.info("查询失败");
        }

        writer.flush();
        writer.close();
    }

    @RequestMapping("/insertUser.action")
    private void insertUser(HttpServletRequest req, HttpServletResponse rep) throws Exception {
        rep.setCharacterEncoding("UTF-8");
        rep.setContentType("application/json;charset=UTF-8");//防止数据传递乱码
        rep.setHeader("Content-type", "text/json;charset=UTF-8");

        User user = new User();
        user.setUid("324628364872638");
        user.setName("张龙");
        user.setUsername("ffff");
        user.setPassword("123456");
        userService.inserUser(user);

        PrintWriter writer = rep.getWriter();
        writer.println("插入" + user.getName() + "成功");
        writer.flush();
        writer.close();
    }

    @RequestMapping("/deleteUser.action")
    private void deleteUser(HttpServletRequest req, HttpServletResponse rep) throws Exception {
        rep.setCharacterEncoding("UTF-8");
        rep.setContentType("application/json;charset=UTF-8");//防止数据传递乱码
        rep.setHeader("Content-type", "text/json;charset=UTF-8");

        User user = userService.selectUserById(14);
        PrintWriter writer = rep.getWriter();
        try {
            if (userService.deleteUser(user) > 0) {
                writer.println("删除" + user.getName() + "成功");
            } else {
                writer.println("删除" + user.getName() + "失败");
            }
        } catch (Exception e) {
            writer.println("删除" + user.getName() + "失败");
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }

    @RequestMapping("/updateUser.action")
    private void updateUser(HttpServletRequest req, HttpServletResponse rep) throws Exception {
        rep.setCharacterEncoding("UTF-8");
        rep.setContentType("application/json;charset=UTF-8");//防止数据传递乱码
        rep.setHeader("Content-type", "text/json;charset=UTF-8");

        User user = userService.selectUserById(12);
        user.setName("牵牛啊");
        PrintWriter writer = rep.getWriter();
        try {
            if (userService.updateUser(user) > 0) {
                writer.println("更新" + user.getName() + "成功");
            } else {
                writer.println("更新" + user.getName() + "失败");
            }
        } catch (Exception e) {
            writer.println("更新" + user.getName() + "失败");
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }
    }
}
