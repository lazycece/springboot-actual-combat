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
public class FanoutConsumer {

    @RabbitListener(queues = {"fanout.queue.one"})
    public void fanoutQueueOneConsumer(Message message) {
        log.info("fanout.queue.one -> {} ", message.toString());
    }

    @RabbitListener(queues = {"fanout.queue.two"})
    public void fanoutQueueTwoConsumer(Message message) {
        log.info("fanout.queue.two-> {} ", message.toString());
    }

    @RabbitListener(queues = {"fanout.queue.three"})
    public void fanoutQueueThreeConsumer(Message message) {
        log.info("fanout.queue.three -> {} ", message.toString());
    }
}
