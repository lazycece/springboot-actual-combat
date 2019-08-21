package com.lazycece.sbac.rocketmq.order;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author lazycece
 * @date 2019/8/21
 */
@Component
public class OrderProducer {

    private static final Integer NUM = 10;

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void sendSyncOrderly() {
        String message = "orderly message: ";
        for (int i = 0; i < NUM; i++) {
            // 模拟有序消费
            rocketMQTemplate.syncSendOrderly("topic-orderly", message + i, "select_queue_key");
            // 模拟无序消费
//            rocketMQTemplate.syncSend("topic-orderly", message + i);
        }
    }
}
