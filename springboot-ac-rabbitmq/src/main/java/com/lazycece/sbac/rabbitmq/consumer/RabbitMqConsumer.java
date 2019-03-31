package com.lazycece.sbac.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lazycece
 * @date 2019/03/31
 */
@Component
public class RabbitMqConsumer {

    @RabbitListener
    public void listener(){

    }
}
