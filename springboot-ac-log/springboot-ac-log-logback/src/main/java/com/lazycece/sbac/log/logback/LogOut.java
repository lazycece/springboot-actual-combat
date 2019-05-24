package com.lazycece.sbac.log.logback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * @author lazycece
 * @date 2019/5/24
 */
@Configuration
@Slf4j
public 	class LogOut implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.debug("log level -> debug");
        log.info("log level -> info");
        log.warn("log level -> warn");
        log.error("log level -> error");
    }
}