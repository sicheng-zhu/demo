package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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

		UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1",
				"李老师", "010-56253825", "Y");
		UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1",
				"王老师", "010-56253825", "N");



		return Arrays.asList(address1, address2);
	}

}
