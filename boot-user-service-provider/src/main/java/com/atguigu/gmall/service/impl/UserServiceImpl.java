package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@DubboService // 暴露服务
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public boolean setUserAddress(UserAddress userAddress) {
		UserAddress returned = mongoTemplate.save(userAddress);

		return returned != null;
	}

	@Override
	public List<UserAddress> getUserAddressList(String userId) {
		Query query = Query.query(Criteria.where("userId").is(userId));
		List<UserAddress> userAddressList = mongoTemplate.find(query, UserAddress.class,"userAddress");

		return userAddressList;
	}

}
