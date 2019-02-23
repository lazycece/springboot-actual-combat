package com.lazycece.sbac.exception.controller;

import com.lazycece.sbac.exception.controller.req.UserInfoReq;
import com.lazycece.sbac.exception.response.ResCode;
import com.lazycece.sbac.exception.response.ResponseData;
import com.lazycece.sbac.exception.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author lazycece
 * @date 2019/02/23
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Validated
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/add")
    public ResponseData addUserInfo(@Validated UserInfoReq req) {
        log.info("添加用户成功,此处参数验证已通过,不存在validation校验异常: {}", req.toString());
        return ResponseData.builder()
                .code(ResCode.SUCCESS)
                .message("success")
                .build();
    }

    @GetMapping("/info")
    public ResponseData queryUserInfo(String username) {
        return ResponseData.builder()
                .code(ResCode.SUCCESS)
                .message("success")
                .data(userService.getUserInfo(username))
                .build();
    }


    @GetMapping("/inner/error")
    public ResponseData innerError() {
        //测验未知异常
        int temp = 1/0;
        return ResponseData.builder()
                .code(ResCode.SUCCESS)
                .message("success")
                .build();
    }
}
