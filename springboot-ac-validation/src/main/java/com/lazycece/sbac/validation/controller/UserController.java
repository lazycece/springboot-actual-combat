package com.lazycece.sbac.validation.controller;

import com.lazycece.sbac.validation.controller.req.UserInfoReq;
import com.lazycece.sbac.validation.group.Update;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lazycece
 * @date 2019/02/15
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @PutMapping("/add")
    public String addUserInfo(@Validated UserInfoReq req) {
        log.info("添加用户成功: {}", req.toString());
        return "success";
    }

    @PostMapping("/update")
    public String updateUserInfo(@Validated(value = {Update.class}) UserInfoReq req) {
        log.info("更新用户成功: {}", req.toString());
        return "success";
    }
}
