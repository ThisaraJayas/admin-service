package com.admin.admin_service.config.db;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories(
        basePackages = "com.admin.admin_service.repository.admin",
        mongoTemplateRef = "adminMongoTemplate"
)
public class AdminMongoConfig {

    @Bean(name = "adminMongoDatabaseFactory")
    public MongoDatabaseFactory adminMongoDatabaseFactory() {
        return new SimpleMongoClientDatabaseFactory(
                "mongodb+srv://Thisal:Thisal@cluster0.fjuv6mx.mongodb.net/admin_service?retryWrites=true&w=majority&appName=Cluster0"
        );
    }

    @Bean(name = "adminMongoTemplate")
    public MongoTemplate adminMongoTemplate(
            @Qualifier("adminMongoDatabaseFactory") MongoDatabaseFactory mongoDatabaseFactory
    ) {
        return new MongoTemplate(mongoDatabaseFactory);
    }
}
