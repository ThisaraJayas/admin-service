package com.admin.admin_service.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import java.util.Date;

@Data
@Document(collection = "restaurants")
public class Restaurant {
    @Id
    private String id;

    private String name;
    private String owner;
    private String address;
    private int rating;
    private boolean isVerified;

    @CreatedDate
    private Date createdAt;
}
