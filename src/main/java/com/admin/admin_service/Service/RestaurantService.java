package com.admin.admin_service.Service;

import com.admin.admin_service.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants();

    Restaurant createRestaurant(Restaurant restaurant);

    Restaurant verifyRestaurant(String id, boolean isVerified);

    void deleteRestaurant(String id);
}
