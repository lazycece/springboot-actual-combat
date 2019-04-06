package com.lazycece.sbac.rabbitmq.producer;

import com.lazycece.sbac.rabbitmq.entity.Message;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author lazycece
 * @date 2019/04/04
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitMqProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;
    private Message<String> message;

    @Before
    public void buildMessage() {
        message = new Message<>();
        message.setId(UUID.randomUUID().toString());
        message.setContent("Hello, springboot-ac-rabbitmq !");
    }

    @Test
    public void directProducer() {
        rabbitTemplate.convertAndSend("direct.exchange", "direct.queue", message);
    }

    @Test
    public void fanoutProducer() {
        rabbitTemplate.convertAndSend("fanout.exchange", "", message);
    }

    @Test
    public void topicProducer() {
        rabbitTemplate.convertAndSend("topic.exchange", "routing", message);
    }

    @Test
    public void headersProducer() {
        rabbitTemplate.convertAndSend("headers.exchange", "", message,
                m -> {
                    m.getMessageProperties().getHeaders().put("headers-key", null);
                    return m;
                });
    }

}
