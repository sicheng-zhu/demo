package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.Order;
import com.atguigu.gmall.bean.UserAddress;
import org.bson.types.ObjectId;

import java.util.List;

public interface OrderService {
    /**
     * 初始化订单
     * @param userId
     */
    public UserAddress initOrder(String userId);

    public ObjectId addOrder(Order order);

    public Order getOrder(String id);
}
