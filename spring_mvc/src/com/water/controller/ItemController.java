package com.water.controller;

import com.water.pojo.Items;
import com.water.service.ItemService;
import com.water.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Water on 2017/6/15.
 * Email:water471871679@gmail.com
 */
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    //包名+类名+方法名
    @RequestMapping(value = "/itemlist.action")
    public ModelAndView itemlist(){
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setView();

//        从MySQL中查询

        List<Items> list = itemService.selectItemsList();
//        for (int i = 0; i<8;i++) {
//            list.add(new Items(i, "商品" + i, 2000f, new Date(), "最新上市"));
//        }
        LogUtils.info("商品控制器","listsize"+list.size());
        modelAndView.addObject("itemList",list);
        modelAndView.setViewName("itemList");
        return modelAndView;
    }
}

