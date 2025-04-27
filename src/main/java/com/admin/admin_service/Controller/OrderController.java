package com.admin.admin_service.Controller;
import com.admin.admin_service.Service.OrderService;
import com.admin.admin_service.dto.OrderDTO;
import com.admin.admin_service.dto.UpdateOrderStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO dto) {
        return ResponseEntity.ok(orderService.createOrder(dto));
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDTO>> getOrdersByUser(@PathVariable String userId) {
        return ResponseEntity.ok(orderService.getOrdersByUser(userId));
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<OrderDTO>> getOrdersByRestaurant(@PathVariable String restaurantId) {
        return ResponseEntity.ok(orderService.getOrdersByRestaurant(restaurantId));
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<OrderDTO> updateOrderStatus(
            @PathVariable String orderId,
            @RequestBody UpdateOrderStatusDTO dto) {
        return ResponseEntity.ok(orderService.updateOrderStatus(orderId, dto));
    }
}
