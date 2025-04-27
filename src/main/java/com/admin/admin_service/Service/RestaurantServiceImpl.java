package com.admin.admin_service.Service;

import com.admin.admin_service.model.Restaurant;
import com.admin.admin_service.repository.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService{
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        restaurant.setCreatedAt(new Date());
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant verifyRestaurant(String id, boolean isVerified) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            restaurant.setVerified(isVerified);
            return restaurantRepository.save(restaurant);
        }
        throw new RuntimeException("Restaurant not found");
    }

    @Override
    public void deleteRestaurant(String id) {
        restaurantRepository.deleteById(id);
    }
}
