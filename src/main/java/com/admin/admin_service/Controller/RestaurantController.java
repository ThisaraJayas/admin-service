package com.admin.admin_service.Controller;

import com.admin.admin_service.Service.RestaurantService;
import com.admin.admin_service.dto.VerifyRequest;
import com.admin.admin_service.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    // Get all restaurants
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    // Create new restaurant
    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);
    }
    @PutMapping("/{id}/verify")
    public ResponseEntity<Restaurant> verifyRestaurant(@PathVariable String id, @RequestBody VerifyRequest request) {
        return ResponseEntity.ok(restaurantService.verifyRestaurant(id, request.isIsVerified()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable String id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }
}
