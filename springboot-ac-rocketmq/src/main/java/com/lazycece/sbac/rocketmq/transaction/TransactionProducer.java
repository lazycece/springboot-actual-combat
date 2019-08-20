package com.lazycece.sbac.rocketmq.transaction;

import com.lazycece.sbac.rocketmq.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author lazycece
 * @date 2019/8/20
 */
public class TransactionProducer {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void produce(){
        Message<String> message = new Message<>();
        message.setId(UUID.randomUUID().toString());
        message.setContent("transaction message");
//        rocketMQTemplate.sendMessageInTransaction("tx-group","topic-tx",message,null);
    }

}

