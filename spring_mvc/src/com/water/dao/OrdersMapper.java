package com.water.dao;

import com.water.pojo.Orders;

import java.util.List;

/**
 * Created by Water on 2017/6/21.
 * Email:water471871679@gmail.com
 */
public interface OrdersMapper {
    List<Orders> selectOrdersList();

    /**
     * 一对一关联,以订单为中心关联用户
     */
    List<Orders> selectOrders();

}
