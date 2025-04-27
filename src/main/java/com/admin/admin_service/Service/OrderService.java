package com.admin.admin_service.Service;

import com.admin.admin_service.dto.OrderDTO;
import com.admin.admin_service.dto.UpdateOrderStatusDTO;

import java.util.List;

public interface OrderService {
    OrderDTO createOrder(OrderDTO createOrderDTO);
    List<OrderDTO> getAllOrders();
    List<OrderDTO> getOrdersByUser(String userId);
    List<OrderDTO> getOrdersByRestaurant(String restaurantId);
    OrderDTO updateOrderStatus(String orderId, UpdateOrderStatusDTO updateOrderStatusDTO);
}
