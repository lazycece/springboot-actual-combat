package com.lazycece.sbac.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lazycece
 * @date 2019/04/04
 */
@Configuration
public class HeadersConfig {

    @Bean
    public Queue headersQueue() {
        return QueueBuilder.durable("headers.queue").build();
    }

    @Bean
    public HeadersExchange headersExchange() {
        return (HeadersExchange) ExchangeBuilder.headersExchange("headers.exchange").build();
    }

    @Bean
    public Binding headersBinding() {
        return BindingBuilder.bind(headersQueue()).to(headersExchange()).where("headers-key").exists();
    }
}
