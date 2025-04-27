package com.admin.admin_service.Service;

import com.admin.admin_service.model.NotificationTemplate;

import java.util.List;

public interface NotificationService {
    List<NotificationTemplate> getAllTemplates();

    NotificationTemplate createTemplate(NotificationTemplate template);

    NotificationTemplate updateTemplate(String id, NotificationTemplate template);

    void deleteTemplate(String id);

    void sendNotificationToAllUsers(String templateId);
}
