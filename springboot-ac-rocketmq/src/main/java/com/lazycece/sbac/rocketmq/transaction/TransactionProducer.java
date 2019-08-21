package com.lazycece.sbac.rocketmq.transaction;

import com.lazycece.sbac.rocketmq.message.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author lazycece
 * @date 2019/8/20
 */
@Component
@Slf4j
public class TransactionProducer {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void produce() {
        Message<String> message = new Message<>();
        message.setId(UUID.randomUUID().toString());
        message.setContent("transaction message");
        log.info("========sending message=========");
        rocketMQTemplate.sendMessageInTransaction("tx-group", "topic-tx", MessageBuilder.withPayload(message).build(), null);
        log.info("========finish send =========");
    }

}

