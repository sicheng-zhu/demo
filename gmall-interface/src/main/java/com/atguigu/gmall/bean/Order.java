package com.atguigu.gmall.bean;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@Document(collection = "order")
public class Order implements Serializable {

    @Id
    private ObjectId id;

    @Field
    private ObjectId userAddressId;
}
