package com.admin.admin_service.model.enums;


public enum UserRole {
    admin("ROLE_ADMIN"),
    customer("ROLE_CUSTOMER"),
    restaurant("ROLE_RESTAURANT_ADMIN"),
    delivery("ROLE_DELIVERY_PERSONNEL"),
    rider("ROLE_RIDER");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}