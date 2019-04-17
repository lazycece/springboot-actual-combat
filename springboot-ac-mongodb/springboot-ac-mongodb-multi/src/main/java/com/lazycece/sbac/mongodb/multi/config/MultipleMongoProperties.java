package com.lazycece.sbac.mongodb.multi.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author lazycece
 */
@Configuration
public class MultipleMongoProperties {

    @Primary
    @Bean(name = "mongoDefaultProperties")
    @ConfigurationProperties(prefix = "mongodb.default")
    public MongoProperties mongoDefaultProperties() {
        return new MongoProperties();
    }

    @Bean(name = "mongoLogProperties")
    @ConfigurationProperties(prefix = "mongodb.log")
    public MongoProperties mongoLogProperties() {
        return new MongoProperties();
    }
}
