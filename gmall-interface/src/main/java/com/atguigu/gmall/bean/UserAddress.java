package com.atguigu.gmall.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * 用户地址
 */
@Data
@Document(collection = "userAddress")
public class UserAddress implements Serializable {

    /**
     * 如果自己不设置@Id主键，mongo会自动生成一个唯一主键，并且插入时效率远高于自己设置主键。
     * https://blog.csdn.net/zdwzzu2006/article/details/131541650
     */
//    @Id
//    private Integer id;
    @Field
    private String userAddress; //用户地址
    @Field
    private String userId; //用户id
    @Field
    private String consignee; //收货人
    @Field
    private String phoneNum; //电话号码
    @Field
    private String isDefault; //是否为默认地址    Y-是     N-否

    public UserAddress() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UserAddress(Integer id, String userAddress, String userId, String consignee, String phoneNum,
                       String isDefault) {
        super();
//        this.id = id;
        this.userAddress = userAddress;
        this.userId = userId;
        this.consignee = consignee;
        this.phoneNum = phoneNum;
        this.isDefault = isDefault;
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
}
