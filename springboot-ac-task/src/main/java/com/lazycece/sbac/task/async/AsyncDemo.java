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
    @Resource
    private AsyncFuture asyncFuture;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("begin");
        asyncRun.run();
        Future<String> future = asyncFuture.run();
        System.out.println("end");
        System.out.println(future.get(1, TimeUnit.SECONDS));
    }
}

@Component
class AsyncRun {
    @Async
    void run() {
        System.out.println("async running");
    }
}

@Component
class AsyncFuture {
    @Async
    Future<String> run() {
        System.out.println("async-future running");
        return new AsyncResult<>("async-future run");
    }
}