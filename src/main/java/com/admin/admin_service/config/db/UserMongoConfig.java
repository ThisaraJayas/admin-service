package com.admin.admin_service.config.db;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
        basePackages = "com.admin.admin_service.repository.user",
        mongoTemplateRef = "userMongoTemplate"
)
public class UserMongoConfig {

    @Primary
    @Bean(name = "userMongoDatabaseFactory")
    public MongoDatabaseFactory userMongoDatabaseFactory() {
        return new SimpleMongoClientDatabaseFactory(
                "mongodb+srv://Thisal:Thisal@cluster0.fjuv6mx.mongodb.net/user_service?retryWrites=true&w=majority&appName=Cluster0"
        );
    }

    @Primary
    @Bean(name = "userMongoTemplate")
    public MongoTemplate userMongoTemplate(
            @Qualifier("userMongoDatabaseFactory") MongoDatabaseFactory mongoDatabaseFactory
    ) {
        return new MongoTemplate(mongoDatabaseFactory);
    }
}