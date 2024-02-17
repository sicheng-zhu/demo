package com.atguigu.gmall.controller;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserAddressController {

    @Autowired
    UserService userAddressService;

    @PostMapping("/addUserAddress")
    public String addUserAddress(@RequestBody UserAddress userAddress) {
        ObjectId objectId = userAddressService.addUserAddress(userAddress);
        return objectId.toString();
    }

    @GetMapping("/getUserAddress")
    public UserAddress getUserAddress(@RequestParam(value = "id") String id) {
        return userAddressService.getUserAddress(id);
    }

    @PutMapping("/updateUserAddress")
    public boolean updateUserAddress(@RequestBody UserAddress userAddress) {
        return userAddressService.updateUserAddress(userAddress);
    }

    @DeleteMapping("/deleteUserAddress")
    public boolean deleteUserAddress(@RequestParam(value = "id") String id) {
        return userAddressService.deleteUserAddress(id);
    }
}

//http://localhost:8082/

// addUserAddress
//{
//    "userAddress": "1",
//    "userId": "1",
//    "consignee": "1",
//    "phoneNum": "1",
//    "isDefault": "1"
//}

// updateUserAddress
//{
//    "id": "65cf116eb737bf1fc4a75ca9",
//    "userId": "3"
//}
