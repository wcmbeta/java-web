package com.water.service;

import com.water.pojo.Orders;

import java.util.List;

/**
 * Created by Water on 2017/6/17.
 * Email:water471871679@gmail.com
 */
public interface OrdersService {

    List<Orders> selectOrdersWithUser();
}
