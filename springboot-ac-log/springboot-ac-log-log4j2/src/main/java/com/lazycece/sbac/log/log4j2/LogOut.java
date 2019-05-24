package com.lazycece.sbac.log.log4j2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

/**
 * @author lazycece
 * @date 2019/5/24
 */
@Configuration
@Slf4j
public 	class LogOut implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.debug("log level -> debug");
        log.info("log level -> info");
        log.warn("log level -> warn");
        log.error("log level -> error");
    }
}