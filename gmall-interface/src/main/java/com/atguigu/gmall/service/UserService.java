package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UserAddress;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * 用户服务
 */
public interface UserService {

    public ObjectId addUserAddress(UserAddress userAddress);

    /**
     * 按照用户id返回所有的收货地址
     * @param userId
     * @return
     */
    public List<UserAddress> getUserAddressList(String userId);

    public boolean updateUserAddress(UserAddress userAddress);

    public boolean deleteUserAddress(String _id);
}
