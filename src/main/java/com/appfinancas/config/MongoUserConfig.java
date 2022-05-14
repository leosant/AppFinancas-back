package com.appfinancas.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.appfinancas.repositories",
        mongoTemplateRef = "UserTemplate")
public class MongoUserConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "mongodb.userdb")
    public MongoProperties getUserProps() {
        return new MongoProperties();
    }

    @Bean(name = "UserTemplate")
    public MongoTemplate userTemplate() {
        return new MongoTemplate(userFactory(getUserProps()));
    }

    @Bean
    public MongoDatabaseFactory userFactory(MongoProperties userProps) {
        return new SimpleMongoClientDatabaseFactory(userProps.getUri());
    }
}
