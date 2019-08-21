package com.lazycece.sbac.rocketmq.offset;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author lazycece
 * @date 2019/8/21
 */

@Component
@Slf4j
public class OffsetProducer {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void send() {
        String message = "offset message:  ";
        for (int i = 0; i < 100; i++) {
            rocketMQTemplate.syncSendOrderly("topic-offset", message + i, "offset_orderly_key");
        }
    }
}
