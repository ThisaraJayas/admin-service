package com.admin.admin_service.repository.order;

import com.admin.admin_service.model.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByUser(ObjectId userId);
    List<Order> findByRestaurant(ObjectId restaurantId);
}
