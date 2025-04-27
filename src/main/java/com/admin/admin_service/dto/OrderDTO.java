package com.admin.admin_service.dto;
import com.admin.admin_service.model.Order;
import com.admin.admin_service.model.enums.OrderStatus;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {
    private String id;
    private String userId;
    private String restaurantId;
    private List<Order.Item> items;
    private double totalAmount;
    private OrderStatus status;
    private String deliveryAddress;
    private Date deliveryTime;
    private Date createdAt;
}