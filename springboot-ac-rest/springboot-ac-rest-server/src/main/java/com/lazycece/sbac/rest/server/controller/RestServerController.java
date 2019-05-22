package com.lazycece.sbac.rest.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lazycece
 * @date 2019/5/22
 */
@RestController
@Slf4j
public class RestServerController {

    @GetMapping("/rest/{name}")
    public String rest(@PathVariable String name) {
        log.info("request -> {}", name);
        return "Hello, " + name + " !";
    }

}
