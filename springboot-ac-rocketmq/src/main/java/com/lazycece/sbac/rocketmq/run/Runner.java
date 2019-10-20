package com.lazycece.sbac.rocketmq.run;

import com.lazycece.sbac.rocketmq.messagemodel.MessageModelProducer;
import com.lazycece.sbac.rocketmq.offset.OffsetProducer;
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
    @Resource
    private OffsetProducer offsetProducer;
    @Resource
    private MessageModelProducer messageModelProducer;

    @Override
    public void run(String... args) throws Exception {
//        rocketmqProducer.sync();
//        rocketmqProducer.oneWay();
//        rocketmqProducer.async();

        transactionProducer.produce();
//        orderProducer.sendSyncOrderly();
//        tagProducer.sendTagsMessage();
//        offsetProducer.send();
//        messageModelProducer.send();
    }
}
