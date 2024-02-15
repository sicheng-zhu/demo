package com.atguigu.gmall.controller;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping("/initOrder")
    public List<UserAddress> initOrder(@RequestParam("uid")String userId) {
        return orderService.initOrder(userId);
    }

    @ResponseBody
    @PostMapping("/setUserAddress")
    public Boolean setUserAddress(@RequestBody UserAddress userAddress) {
        return orderService.setUserAddress(userAddress);
    }
}

//http://localhost:8082/initOrder/?uid=1
//https://zhuanlan.zhihu.com/p/338274693
//https://blog.csdn.net/a1120467800/article/details/109954145

//{
//    "id": 3,
//    "userAddress": "1",
//    "userId": "1",
//    "consignee": "1",
//    "phoneNum": "1",
//    "isDefault": "1"
//}
