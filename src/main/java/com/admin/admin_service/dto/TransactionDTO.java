package com.admin.admin_service.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TransactionDTO {
    private String userId;
    private String userName;
    private double totalAmount;
    private List<OrderSummaryDTO> orders;

    @Data
    public static class OrderSummaryDTO {
        private String orderId;
        private Date orderDate;
        private List<OrderItemDTO> items;
        private double orderTotal;
        private String status;
    }

    @Data
    public static class OrderItemDTO {
        private String name;
        private int quantity;
        private double price;
    }
}