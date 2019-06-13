package com.lazycece.sbac.task.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author lazycece
 * @date 2019/6/11
 */
@Component
public class ScheduleDemo {

    @Scheduled(cron = "${task.cron}")
    public void run() {
        System.out.println(" schedule running");
    }
}
