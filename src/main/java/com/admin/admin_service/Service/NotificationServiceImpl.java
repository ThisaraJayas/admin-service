package com.admin.admin_service.Service;

import com.admin.admin_service.model.NotificationTemplate;
import com.admin.admin_service.model.User;
import com.admin.admin_service.repository.admin.NotificationTemplateRepository;
import com.admin.admin_service.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService{
    @Autowired
    private NotificationTemplateRepository templateRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<NotificationTemplate> getAllTemplates() {
        return templateRepository.findAll();
    }
    @Override
    public NotificationTemplate createTemplate(NotificationTemplate template) {
        template.setCreatedAt(new Date());
        template.setUpdatedAt(new Date());
        return templateRepository.save(template);
    }
    @Override
    public NotificationTemplate updateTemplate(String id, NotificationTemplate template) {
        Optional<NotificationTemplate> existing = templateRepository.findById(id);
        if(existing.isPresent()) {
            NotificationTemplate updated = existing.get();
            updated.setName(template.getName());
            updated.setSubject(template.getSubject());
            updated.setContent(template.getContent());
            updated.setUpdatedAt(new Date());
            return templateRepository.save(updated);
        }
        throw new RuntimeException("Template not found");
    }
    @Override
    public void deleteTemplate(String id) {
        templateRepository.deleteById(id);
    }

    @Override
    public void sendNotificationToAllUsers(String templateId) {
        NotificationTemplate template = templateRepository.findById(templateId)
                .orElseThrow(() -> new RuntimeException("Template not found"));

        List<User> users = userRepository.findAll();
        List<String> emails = users.stream().map(User::getEmail).toList();

//        emailService.sendBulkEmail(emails, template.getSubject(), template.getContent());
    }
}
