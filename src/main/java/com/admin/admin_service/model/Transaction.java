package com.admin.admin_service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;
    private String userId;
    private String userName;
    private double totalAmount;
    private Date transactionDate = new Date();
    private List<OrderSummary> orders;

    @Data
    public static class OrderSummary {
        private String orderId;
        private Date orderDate;
        private List<OrderItem> items;
        private double orderTotal;
        private String status;
    }

    @Data
    public static class OrderItem {
        private String name;
        private int quantity;
        private double price;
    }
}