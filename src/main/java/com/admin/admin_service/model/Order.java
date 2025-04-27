package com.admin.admin_service.model;

import com.admin.admin_service.model.enums.OrderStatus;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private ObjectId user;
    private ObjectId restaurant;
    private List<Item> items;
    private double totalAmount;
    private OrderStatus status = OrderStatus.ready;
    private String deliveryAddress;
    private Date deliveryTime;

    @CreatedDate
    private Date createdAt;

    @Data
    public static class Item {
        @Id
        private String id;
        private int quantity;
        private String name;
        private double price;
    }
}

