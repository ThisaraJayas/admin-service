package com.admin.admin_service.Service;

import com.admin.admin_service.dto.ItemDTO;
import com.admin.admin_service.dto.OrderDTO;
import com.admin.admin_service.dto.UpdateOrderStatusDTO;
import com.admin.admin_service.model.Order;
import com.admin.admin_service.model.enums.OrderStatus;
import com.admin.admin_service.repository.order.OrderRepository;
import com.admin.admin_service.repository.restaurant.RestaurantRepository;
import com.admin.admin_service.repository.user.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private UserService userService;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public OrderDTO createOrder(OrderDTO createOrderDTO) {
        // Validate user and restaurant exist
        userRepository.findById(createOrderDTO.getUserId());
        restaurantRepository.findById(createOrderDTO.getRestaurantId());

        Order order = new Order();
//        order.setUser(createOrderDTO.getUserId());
//        order.setRestaurant(createOrderDTO.getRestaurantId());
//        order.setItems(convertItemDTOs(createOrderDTO.getItems()));
        order.setTotalAmount(createOrderDTO.getTotalAmount());
        order.setDeliveryAddress(createOrderDTO.getDeliveryAddress());
        order.setDeliveryTime(createOrderDTO.getDeliveryTime());

        Order savedOrder = orderRepository.save(order);
        return convertToDTO(savedOrder);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrdersByUser(String userId) {
        ObjectId userObjectId = new ObjectId(userId); // Convert String to ObjectId
        return orderRepository.findByUser(userObjectId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrdersByRestaurant(String restaurantId) {
        ObjectId restaurantObjectId = new ObjectId(restaurantId);
        return orderRepository.findByRestaurant(restaurantObjectId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public OrderDTO updateOrderStatus(String orderId, UpdateOrderStatusDTO dto) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        try {
            OrderStatus status = OrderStatus.valueOf(dto.getStatus().toUpperCase());
            order.setStatus(status);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid status: " + dto.getStatus());
        }

        return convertToDTO(orderRepository.save(order));
    }

    private List<Order.Item> convertItemDTOs(List<ItemDTO> itemDTOs) {
        return itemDTOs.stream()
                .map(dto -> {
                    Order.Item item = new Order.Item();
//                    item.setProductId(dto.getProductId());
                    item.setQuantity(dto.getQuantity());
                    item.setName(dto.getName());
                    item.setPrice(dto.getPrice());
                    return item;
                })
                .collect(Collectors.toList());
    }

    private OrderDTO convertToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setUserId(order.getUser().toHexString()); // Convert ObjectId to String
        dto.setRestaurantId(order.getRestaurant().toHexString());
        dto.setItems(order.getItems());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setStatus(order.getStatus());
        dto.setDeliveryAddress(order.getDeliveryAddress());
        dto.setDeliveryTime(order.getDeliveryTime());
        dto.setCreatedAt(order.getCreatedAt());
        return dto;
    }
}
