package com.admin.admin_service.repository.restaurant;

import com.admin.admin_service.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
}
