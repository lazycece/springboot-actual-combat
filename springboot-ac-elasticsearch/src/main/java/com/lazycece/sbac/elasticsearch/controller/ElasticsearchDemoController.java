package com.lazycece.sbac.elasticsearch.controller;

import com.lazycece.sbac.elasticsearch.entity.User;
import com.lazycece.sbac.elasticsearch.repository.UserEsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author lazycece
 * @date 2018/10/16
 */
@RestController
@RequestMapping("/elasticsearch")
public class ElasticsearchDemoController {

    private UserEsRepository userEsRepository;

    @Autowired
    public ElasticsearchDemoController(UserEsRepository userEsRepository) {
        this.userEsRepository = userEsRepository;
    }

    @GetMapping("/demo")
    public Object demo() {
        return "welcome to elasticsearch cluster demo ...";
    }

    @PutMapping("/user/add")
    public Object addUserInfo(User user) {
        if (StringUtils.isEmpty(user.getName().trim())) {
            return "add user fail: username is null ...";
        }
        User userFind = userEsRepository.findByUsername(user.getUsername());
        if (userFind != null) {
            return "add user fail: user exist";
        }
        userEsRepository.save(user);
        return "add user success ...";
    }

    @GetMapping("/user/info")
    public Object getUserInfo(@RequestParam String username) {
        return userEsRepository.findByUsername(username);
    }
}
