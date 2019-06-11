package com.lazycece.sbac.task.async;

import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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
        asyncRun.run();
        System.out.println("end");
    }
}

@Component
class AsyncRun {
    @Async
    void run() {
        System.out.println("async running");
    }
}