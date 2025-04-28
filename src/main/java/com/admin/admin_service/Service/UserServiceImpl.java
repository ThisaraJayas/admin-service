package com.admin.admin_service.Service;

import com.admin.admin_service.model.User;
import com.admin.admin_service.model.enums.UserRole;
import com.admin.admin_service.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUserRole(String id, String role) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            try {
                UserRole userRole = UserRole.valueOf(role.toLowerCase());
                user.setRole(userRole);
                return userRepository.save(user);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid role: " + role);
            }
        }
        throw new RuntimeException("User not found");
    }


    @Override
    public User verifyUser(String id, boolean isVerified) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            user.setVerified(isVerified);
            return userRepository.save(user);
        }
        throw new RuntimeException("User not found");
    }

    @Override
    public List<User> findByNameContainingIgnoreCase(String name) {
        return userRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
