package com.lazycece.sbac.devtools.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lazycece
 * @date 2019/2/22
 */
@RestController
@RequestMapping("/devtools")
public class DevtoolsController {

    @Value(value = "${project.value}")
    private String value;

    @GetMapping("/clazz")
    public Object clazz() {
        return "this is clazz change: aaa";
    }

    @GetMapping("/config")
    public Object config() {
        return "this is config change: " + value;
    }
}
