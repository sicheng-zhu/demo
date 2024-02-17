package com.atguigu.gmall.controller;

import com.atguigu.gmall.bean.Order;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.OrderService;
import org.apache.catalina.User;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/initOrder")
    public UserAddress initOrder(@RequestParam("uid")String userId) {
        return orderService.initOrder(userId);
    }

    @GetMapping("/getOrderNUserAddress")
    public AggregationResults<Document> getOrderNUserAddress(@RequestParam(value = "orderId") String orderId) {
        String[] orderArr = getOrder(orderId);
//        UserAddress userAddress = orderService.initOrder(orderId);

        LookupOperation lookup = Aggregation.lookup("userAddress", "userAddressId", "_id", "userAddress_docs");
        // 用newAggregation接收管道聚合指令，执行，得到结果。
        Aggregation aggregations = Aggregation.newAggregation(lookup);
        // mongoTemplate 直接调用aggregate方法，传入Aggregation对象，基于的表，映射类（这里简单化，我用Document）
        AggregationResults<Document> resultList = mongoTemplate.aggregate(aggregations, "order", Document.class);

        for (Document document : resultList) {
            System.out.println("joined document is: " + document);
            for (Object obj : document.entrySet()) {
                System.out.println("order attribute is: " + obj);
            }

            List<Document> userAddress = (List<Document>) document.get("userAddress_docs");
            System.out.println("userAddress attribute is: " + userAddress.get(0).get("_id"));
        }

        return resultList;
    }

    @PostMapping("/addOrder")
    public String addOrder(@RequestBody Order order) {
        ObjectId objectId = orderService.addOrder(order);
        return objectId.toString();
    }

    @GetMapping("/getOrder")
    public String[] getOrder(@RequestParam(value = "id") String id) {
        Order order = orderService.getOrder(id);

        return new String[] {order.getId().toString(), order.getUserAddressId().toString()};
    }

}

//http://localhost:8081/initOrder/?uid=1

// addOrder
//{
//    "userAddressId": ""
//}
