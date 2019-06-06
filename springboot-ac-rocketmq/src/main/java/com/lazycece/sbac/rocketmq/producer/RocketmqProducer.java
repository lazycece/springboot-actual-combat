package com.lazycece.sbac.rocketmq.producer;

import com.lazycece.sbac.rocketmq.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author lazycece
 * @date 2019/6/6
 */
@Component
public class RocketmqProducer implements CommandLineRunner {

    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    public RocketmqProducer(RocketMQTemplate rocketMQTemplate) {
        this.rocketMQTemplate = rocketMQTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        Message<String> message = new Message<>();
        message.setId(UUID.randomUUID().toString());
        message.setContent("Hello, springboot-ac-rocketmq !");
        rocketMQTemplate.convertAndSend("topic-queue-one", message);
        rocketMQTemplate.convertAndSend("topic-queue-two", "Hello, springboot-ac-rocketmq !");
    }
}
