package com.lazycece.sbac.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lazycece
 * @date 2019/04/04
 */
@Configuration
public class FanoutConfig {

    @Bean
    public Queue fanoutQueueOne() {
        return QueueBuilder.durable("fanout.queue.one").build();
    }

    @Bean
    public Queue fanoutQueueTwo() {
        return QueueBuilder.durable("fanout.queue.two").build();
    }

    @Bean
    public Queue fanoutQueueThree() {
        return QueueBuilder.durable("fanout.queue.three").build();
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return (FanoutExchange) ExchangeBuilder.fanoutExchange("fanout.exchange").build();
    }

    @Bean
    public Binding fanoutBindingOne() {
        return BindingBuilder.bind(fanoutQueueOne()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBindingTwo() {
        return BindingBuilder.bind(fanoutQueueTwo()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBindingThree() {
        return BindingBuilder.bind(fanoutQueueThree()).to(fanoutExchange());
    }
}
