package com.lazycece.sbac.rabbitmq.consumer;

import com.lazycece.sbac.rabbitmq.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lazycece
 * @date 2019/04/04
 */
@Component
@Slf4j
public class AnnotationConsumer {

    @RabbitListener(
            bindings = {
                    @QueueBinding(
                            value = @Queue(name = "topic.queue.annotation"),
                            exchange = @Exchange(name = "topic.exchange", type = ExchangeTypes.TOPIC),
                            key = {"routing"}
                    )
            }
    )
    public void topicQueueOneConsumer(Message message) {
        log.info("topic.queue.annotation -> {} ", message.toString());
    }

}
