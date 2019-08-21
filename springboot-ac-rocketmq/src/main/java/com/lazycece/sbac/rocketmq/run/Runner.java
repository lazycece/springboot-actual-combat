package com.lazycece.sbac.rocketmq.run;

import com.lazycece.sbac.rocketmq.order.OrderProducer;
import com.lazycece.sbac.rocketmq.simple.RocketmqProducer;
import com.lazycece.sbac.rocketmq.tags.TagProducer;
import com.lazycece.sbac.rocketmq.transaction.TransactionProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * @author lazycece
 * @date 2019/8/21
 */
@Component
public class Runner implements CommandLineRunner {

    @Resource
    private RocketmqProducer rocketmqProducer;
    @Resource
    private TransactionProducer transactionProducer;
    @Resource
    private OrderProducer orderProducer;
    @Resource
    private TagProducer tagProducer;

    @Override
    public void run(String... args) throws Exception {
//        rocketmqProducer.sync();
//        transactionProducer.produce();
//        orderProducer.sendSyncOrderly();
        tagProducer.sendTagsMessage();
    }
}
