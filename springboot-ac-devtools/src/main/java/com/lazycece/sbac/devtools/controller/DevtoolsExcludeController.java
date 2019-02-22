package com.lazycece.sbac.devtools.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lazycece
 * @date 2019/2/22
 */
@RestController
@RequestMapping("/devtoolsExclude")
public class DevtoolsExcludeController {


    @GetMapping("/hello")
    public Object hello() {
        return "hello, you will not view me if you exclude me !";
    }
}
