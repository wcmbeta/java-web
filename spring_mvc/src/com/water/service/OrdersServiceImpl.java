package com.water.service;

import com.water.dao.OrdersMapper;
import com.water.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Water on 2017/6/21.
 * Email:water471871679@gmail.com
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> selectOrdersWithUser() {
        return ordersMapper.selectOrders();
    }
}
