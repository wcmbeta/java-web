package com.water.controller;

import com.water.pojo.QueryVo;
import com.water.pojo.User;
import com.water.service.UserService;
import com.water.utils.LogUtils;
import com.water.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
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

    @RequestMapping("/userByQueryVo.action")
    private void findUserByQueryVo(HttpServletRequest req, HttpServletResponse rep) throws Exception {
        Utils.setResponse(rep);
        QueryVo vo = new QueryVo();
        User u = new User();
        u.setName("王");
        vo.setUser(u);


        List<User> list = userService.selectUsersByQueryVo(vo);
        User user = null;
        PrintWriter writer = rep.getWriter();
        if (null != list && !list.isEmpty()) {
            writer.write(list.toString());
            LogUtils.info(list.toString());
        } else {
            writer.write("查询失败");
            LogUtils.info("查询失败");
        }

        writer.flush();
        writer.close();
    }

    /**
     * 用户个数
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/userCount.action")
    private void userCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Utils.setResponse(response);
        Integer count = userService.countUser();

        PrintWriter writer = response.getWriter();
        if (count != null&& count>0) {
            writer.write("查询结果:用户个数->"+count);
            LogUtils.info("查询结果:用户个数->"+count);
        } else {
            writer.write("查询失败");
            LogUtils.info("查询失败");
        }

        writer.flush();
        writer.close();
    }

    @RequestMapping("/userByUP.action")
    private void findUserByUsernameAndPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Utils.setResponse(response);
        User u = new User();
//        u.setUsername("abcd");
        u.setPassword("cc");
        List<User> list = userService.userByUsernameAndPassword(u);

        PrintWriter writer = response.getWriter();
        if (list != null && !list.isEmpty()) {
            User user = list.get(0);
            writer.write("查询结果:"+user.toString());
            LogUtils.info("查询结果:"+user.toString());
        } else {
            writer.write("查询失败");
            LogUtils.info("查询失败");
        }

        writer.flush();
        writer.close();
    }@RequestMapping("/userByIds.action")
    private void findUserByIds(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Utils.setResponse(response);
        QueryVo vo = new QueryVo();
        List<Integer> idList = new ArrayList<>();
        idList.add(2);
        idList.add(3);
        idList.add(4);
        idList.add(5);
        vo.setIds(idList);
        List<User> list = userService.userByIds(vo);

        PrintWriter writer = response.getWriter();
        if (list != null && !list.isEmpty()) {
            writer.write("查询结果:"+list.toString());
            LogUtils.info("查询结果:"+list.toString());
        } else {
            writer.write("查询失败");
            LogUtils.info("查询失败");
        }

        writer.flush();
        writer.close();
    }

}
