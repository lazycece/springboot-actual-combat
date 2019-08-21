package com.lazycece.sbac.rocketmq.tags;

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
public class TagProducer {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void sendTagsMessage() {
        String[] tags = new String[]{"A", "B", "C", "D", "E"};
        String message = "tags message :  ";
        for (int i = 0; i < 5; i++) {
            int k = i % tags.length;
            rocketMQTemplate.syncSend("topic-tags:" + tags[k], message + tags[k]);
        }
    }
}
