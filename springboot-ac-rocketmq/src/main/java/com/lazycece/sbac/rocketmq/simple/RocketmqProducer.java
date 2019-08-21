package com.lazycece.sbac.rocketmq.simple;

import com.lazycece.sbac.rocketmq.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * @author lazycece
 * @date 2019/6/6
 */
@Component
public class RocketmqProducer {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 同步发送
     */
    public void sync() {
        Message<String> message = new Message<>();
        message.setId(UUID.randomUUID().toString());
        message.setContent("Hello, springboot-ac-rocketmq !");
        rocketMQTemplate.convertAndSend("topic-queue-one", message);
        rocketMQTemplate.convertAndSend("topic-queue-two", "Hello, springboot-ac-rocketmq !");
    }

    /**
     * 异步发送
     */
    public void async() {
        Message<String> message = new Message<>();
        message.setId(UUID.randomUUID().toString());
        message.setContent("send async message!");
//        rocketMQTemplate.
    }


}
