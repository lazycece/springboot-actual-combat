package com.lazycece.sbac.task.async;

import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author lazycece
 * @date 2019/6/11
 */
@Component
public class AsyncDemo implements CommandLineRunner {

    @Resource
    private AsyncRun asyncRun;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("begin");
        asyncRun.async();
        Future<String> future = asyncRun.asyncFuture();
        System.out.println("end");
        System.out.println(future.get(1, TimeUnit.SECONDS));
    }
}

@Component
class AsyncRun {
    @Async
    void async() {
        System.out.println("async running");
    }

    @Async
    Future<String> asyncFuture() {
        System.out.println("async-future running");
        return new AsyncResult<>("async-future run");
    }
}