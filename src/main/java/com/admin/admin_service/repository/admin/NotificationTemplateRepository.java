package com.admin.admin_service.repository.admin;

import com.admin.admin_service.model.NotificationTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationTemplateRepository extends MongoRepository<NotificationTemplate, String> {
}
