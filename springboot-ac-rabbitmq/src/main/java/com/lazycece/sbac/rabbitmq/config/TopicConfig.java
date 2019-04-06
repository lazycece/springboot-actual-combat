package com.lazycece.sbac.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lazycece
 * @date 2019/04/04
 */
@Configuration
public class TopicConfig {

    @Bean
    public Queue topicQueueOne() {
        return QueueBuilder.durable("topic.queue.one").build();
    }

    @Bean
    public Queue topicQueueTwo() {
        return QueueBuilder.durable("topic.queue.two").build();
    }

    @Bean
    public TopicExchange topicExchange() {
        return (TopicExchange) ExchangeBuilder.topicExchange("topic.exchange").build();
    }

    @Bean
    public Binding topicBindingOne() {
        return BindingBuilder.bind(topicQueueOne()).to(topicExchange()).with("routing-key");
    }

    @Bean
    public Binding topicBindingTwo() {
        return BindingBuilder.bind(topicQueueTwo()).to(topicExchange()).with("#");
    }
}
