package com.water.controller;

import com.water.pojo.Orders;
import com.water.service.OrdersService;
import com.water.utils.LogUtils;
import com.water.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Water on 2017/6/21.
 * Email:water471871679@gmail.com
 */
@Controller
public class OrderController {
    @Autowired
    private OrdersService ordersService;
    @RequestMapping("/orderWithUser.action")
    private void orderWithUser(HttpServletRequest request, HttpServletResponse response)throws Exception{
        Utils.setResponse(response);
        List<Orders> list = ordersService.selectOrdersWithUser();
        PrintWriter writer = response.getWriter();
        if (list!=null && !list.isEmpty()) {
            writer.println(list.toString());
            LogUtils.info("查询结果:"+list.toString());
        }else{
            writer.println("查询失败");
            LogUtils.info("查询失败");
        }
        writer.flush();
        writer.close();
    }
}
