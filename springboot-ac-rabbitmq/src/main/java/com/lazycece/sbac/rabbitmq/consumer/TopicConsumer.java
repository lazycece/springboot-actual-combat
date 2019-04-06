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
public class TopicConsumer {

    @RabbitListener(queues = {"topic.queue.one"})
    public void topicQueueOneConsumer(Message message) {
        log.info("topic.queue.one -> {} ", message.toString());
    }

    @RabbitListener(queues = {"topic.queue.two"})
    public void topicQueueTwoConsumer(Message message) {
        log.info("topic.queue.two -> {} ", message.toString());
    }
}
