package com.lazycece.sbac.dubbo.consumer.controller;

import com.lazycece.sbac.dubbo.api.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lazycece
 * @date 2019/03/30
 */
@RestController
public class HelloController {

    @Reference(version = "1.0.0", url = "dubbo://127.0.0.1:28080")
    private HelloService helloService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return helloService.hello(name);
    }
}
