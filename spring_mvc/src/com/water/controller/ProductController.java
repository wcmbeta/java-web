package com.water.controller;

import com.google.gson.Gson;
import com.water.pojo.PageBean;
import com.water.pojo.Product;
import com.water.utils.LogUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品控制器
 * Created by Water on 2017/6/16.
 * Email:water471871679@gmail.com
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {
    String[] icons = new String[]{
            "https://m.360buyimg.com/mobilecms/s357x357_jfs/t6736/69/677980342/96634/25066ffc/59433146N383adea1.jpg!q50.jpg",
            "https://m.360buyimg.com/mobilecms/s357x357_jfs/t6484/29/601536848/441400/c5f546c/59421f68Ne4f93436.jpg!q50.jpg",
            "https://m.360buyimg.com/mobilecms/s357x357_jfs/t3022/97/65081922/110465/cabd2366/5791bcfbNc39a4e5b.jpg!q50.jpg",
            "https://m.360buyimg.com/mobilecms/s357x357_jfs/t5608/45/3790170366/135450/a1fcedb2/59422ae7N979fa447.jpg!q50.jpg",
            "https://m.360buyimg.com/mobilecms/s357x357_jfs/t3286/271/4619629740/404149/527e1582/5847fefaNb4e51850.jpg!q50.jpg",
            "https://m.360buyimg.com/mobilecms/s357x357_jfs/t6454/200/632166451/452049/1a83ad1f/59425797N3ea76235.jpg!q50.jpg",
            "https://m.360buyimg.com/mobilecms/s357x357_jfs/t5776/177/1467054202/439404/853485fd/592681bcN17232040.jpg!q50.jpg",
            "https://m.360buyimg.com/mobilecms/s357x357_jfs/t6562/184/428242711/260270/67b39690/593f4e15Nd9cf7b2c.jpg!q50.jpg",
            "https://m.360buyimg.com/mobilecms/s357x357_jfs/t6262/97/646527684/366960/acb31a1c/59424ef9N18410025.jpg!q50.jpg",
            "https://m.360buyimg.com/mobilecms/s357x357_jfs/t1174/35/986364306/393541/77d6ed0/5573ee6fNbd0e12b2.jpg!q50.jpg"
    };


    @RequestMapping("/list.action")
    public void list(HttpServletRequest req, HttpServletResponse rep)throws Exception{
        rep.setContentType("application/json;charset=UTF-8");//防止数据传递乱码
        rep.setHeader("Content-type", "text/json;charset=UTF-8");
        rep.setCharacterEncoding("UTF-8");
        List<Product> list = new ArrayList<>();
        Product product;
        for (int i = 0;i<10;i++) {
            product = new Product();
            product.setId(i);
            product.setAddress("浙江");
            product.setPrice(155+i+"");
            product.setFreightFree(i % 2 == 0);
            product.setName("迈卡龙（MKL）滑板小鱼板 成人青少年儿童代步四轮公路板 全黑大轮+黑色砂纸");
            product.setSmallIcon(icons[i]);
            list.add(product);
            LogUtils.info("商品列表接口",product.toString());
        }
        PageBean pageBean = new PageBean(1,100,10);
        pageBean.setList(list);
        PrintWriter writer = rep.getWriter();
        writer.write(new Gson().toJson(pageBean));
        writer.flush();
        writer.close();
    }
}
