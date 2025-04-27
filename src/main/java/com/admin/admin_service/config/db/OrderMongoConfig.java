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
        basePackages = "com.admin.admin_service.repository.order",
        mongoTemplateRef = "orderMongoTemplate"
)
public class OrderMongoConfig {

    @Primary
    @Bean(name = "orderMongoDatabaseFactory")
    public MongoDatabaseFactory orderMongoDatabaseFactory() {
        return new SimpleMongoClientDatabaseFactory(
                "mongodb+srv://Thisal:Thisal@cluster0.fjuv6mx.mongodb.net/order_service?retryWrites=true&w=majority&appName=Cluster0"
        );
    }

    @Primary
    @Bean(name = "orderMongoTemplate")
    public MongoTemplate orderMongoTemplate(
            @Qualifier("orderMongoDatabaseFactory") MongoDatabaseFactory mongoDatabaseFactory
    ) {
        return new MongoTemplate(mongoDatabaseFactory);
    }
}