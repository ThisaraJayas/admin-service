package com.admin.admin_service.Controller;
import com.admin.admin_service.Service.NotificationService;
import com.admin.admin_service.model.NotificationTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NewsTemplateController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/templates")
    public List<NotificationTemplate> getAllTemplates() {
        return notificationService.getAllTemplates();
    }

    @PostMapping("/templates")
    public NotificationTemplate createTemplate(@RequestBody NotificationTemplate template) {
        return notificationService.createTemplate(template);
    }

    @PutMapping("/templates/{id}")
    public NotificationTemplate updateTemplate(@PathVariable String id, @RequestBody NotificationTemplate template) {
        return notificationService.updateTemplate(id, template);
    }

    @DeleteMapping("/templates/{id}")
    public ResponseEntity<Void> deleteTemplate(@PathVariable String id) {
        notificationService.deleteTemplate(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/send")
    public ResponseEntity<Void> sendNotification(@RequestParam String templateId) {
        notificationService.sendNotificationToAllUsers(templateId);
        return ResponseEntity.ok().build();
    }
}
