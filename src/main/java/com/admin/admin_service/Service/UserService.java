package com.admin.admin_service.Service;

import com.admin.admin_service.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
    void deleteUser(String id);
    User updateUserRole(String id, String role);

    User verifyUser(String id, boolean isVerified);

    List<User> findByNameContainingIgnoreCase(String name);

    User getUserById(String id);
}
