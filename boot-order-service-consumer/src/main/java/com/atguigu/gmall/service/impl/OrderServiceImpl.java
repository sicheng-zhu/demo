package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.bean.Order;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.OrderService;
import com.atguigu.gmall.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 1. 将服务提供者注册到注册中心(暴露服务)
 *   1) 导入dubbo依赖 / 操作zookeeper的客户端(curator)
 *   2) 配置服务提供者
 * 2. 让服务消费者去注册中心订阅服务提供者的服务地址
 */
@Service
public class OrderServiceImpl implements OrderService {

//    @Autowired
    @DubboReference // 在注册中心发现并远程引用提供者服务。
    UserService userService;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public UserAddress initOrder(String userId) {
        System.out.println("用户id:"+userId);
        // 1. 查询用户的收货地址
        UserAddress userAddress = userService.getUserAddress(userId);
        return userAddress;
    }

    @Override
    public ObjectId addOrder(Order order) {
        Order returnedUserOrder = mongoTemplate.save(order, "order");
        return returnedUserOrder.getId();
    }

    @Override
    public Order getOrder(String id) {
        Query query = Query.query(Criteria.where("_id").is(id));
        Order order = mongoTemplate.findOne(query, Order.class,"order");

        return order;
    }
}
