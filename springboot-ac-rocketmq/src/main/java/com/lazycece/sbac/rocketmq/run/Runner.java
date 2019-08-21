package com.lazycece.sbac.rocketmq.run;

import com.lazycece.sbac.rocketmq.simple.RocketmqProducer;
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

    @Override
    public void run(String... args) throws Exception {
//        rocketmqProducer.sync();
        transactionProducer.produce();

    }
}
