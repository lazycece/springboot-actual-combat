package com.lazycece.sbac.mongodb.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author CC
 * 2018.04.09
 */
@Configuration
public class MultipleMongoProperties {

    @Bean(name = "mongoDefaultProperties")
    @Primary
    @ConfigurationProperties(prefix = "mongodb.mongo-default")
    public MongoProperties mongoDefaultProperties() {
        return new MongoProperties();
    }

    @Bean(name = "mongoLogProperties")
    @ConfigurationProperties(prefix = "mongodb.mongo-log")
    public MongoProperties mongoLogProperties() {
        return new MongoProperties();
    }
}
