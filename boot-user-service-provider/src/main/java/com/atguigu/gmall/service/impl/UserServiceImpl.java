package com.atguigu.gmall.service.impl;

import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.UserService;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.apache.dubbo.config.annotation.DubboService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@DubboService // 暴露服务
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public ObjectId addUserAddress(UserAddress userAddress) {
		UserAddress returnedUserAddress = mongoTemplate.save(userAddress);
		return returnedUserAddress.getId();
	}

	@Override
	public List<UserAddress> getUserAddressList(String userId) {
		Query query = Query.query(Criteria.where("userId").is(userId));
		List<UserAddress> userAddressList = mongoTemplate.find(query, UserAddress.class,"userAddress");

		return userAddressList;
	}

	@Override
	public boolean updateUserAddress(UserAddress userAddress) {
		Query query = Query.query(Criteria.where("_id").is(userAddress.getId()));
		Update update = Update.update("userId", userAddress.getUserId());

		UpdateResult updateResult = mongoTemplate.updateFirst(query, update, UserAddress.class,"userAddress");
		return updateResult.getModifiedCount() >= 1;
	}

	@Override
	public boolean deleteUserAddress(String id) {
		Query query = Query.query(Criteria.where("id").is(id));

		// 根据条件删除
//		DeleteResult deleteResult = mongoTemplate.remove(query);
//		mongoTemplate.remove(user);
//		mongoTemplate.remove(User.class);

        // 根据条件删除（可删除多条）
		DeleteResult deleteResult = mongoTemplate.remove(query, UserAddress.class,"userAddress");
		return deleteResult.getDeletedCount() >= 1;
	}
}
