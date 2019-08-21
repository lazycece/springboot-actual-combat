package com.lazycece.sbac.rocketmq.order;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author lazycece
 * @date 2019/8/21
 */
@Component
@Slf4j
@RocketMQMessageListener(topic = "topic-orderly", consumerGroup = "orderly-consumer-group")
public class OrderConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("========{}=======", message);
    }
}
