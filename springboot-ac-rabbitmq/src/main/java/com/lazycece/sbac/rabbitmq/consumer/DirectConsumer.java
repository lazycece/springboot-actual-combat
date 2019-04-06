package com.lazycece.sbac.rabbitmq.consumer;

import com.lazycece.sbac.rabbitmq.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lazycece
 * @date 2019/04/04
 */
@Component
@Slf4j
public class DirectConsumer {

    @RabbitListener(queues = {"direct.queue"})
    public void directQueueConsumer(Message message) {
        log.info("direct.queue -> {} ", message.toString());
    }
}
