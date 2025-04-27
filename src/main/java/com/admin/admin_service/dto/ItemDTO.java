package com.admin.admin_service.dto;

import lombok.Data;

@Data
public class ItemDTO {
    private String id;
    private int quantity;
    private String name;
    private double price;
}
