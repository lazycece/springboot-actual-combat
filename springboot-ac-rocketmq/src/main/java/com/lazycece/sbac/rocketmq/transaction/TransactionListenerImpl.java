package com.lazycece.sbac.rocketmq.transaction;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;


/**
 * @author lazycece
 * @date 2019/8/20
 */
@Slf4j
@RocketMQTransactionListener(txProducerGroup = "tx-group")
public class TransactionListenerImpl implements RocketMQLocalTransactionListener {

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {

        log.info("============== executeLocalTransaction");

        return RocketMQLocalTransactionState.UNKNOWN;
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {

        log.info("============== checkLocalTransaction");

        return RocketMQLocalTransactionState.COMMIT;
    }
}
