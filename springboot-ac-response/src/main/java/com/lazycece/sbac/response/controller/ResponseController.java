package com.lazycece.sbac.response.controller;

import com.lazycece.sbac.response.entity.User;
import com.lazycece.sbac.response.response.ResponseData;
import com.lazycece.sbac.response.response.ResponseMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lazycece
 * @date 2019/02/22
 */
@RestController
@RequestMapping("/response")
public class ResponseController {

    @GetMapping("/data/user/info")
    public ResponseData getDataJson() {
        return ResponseData.success(getUserInfo());
    }

    @GetMapping("/map/user/info")
    public ResponseMap getMapJson() {
        return ResponseMap.success().putting("data", getUserInfo());
    }

    private User getUserInfo() {
        User user = new User();
        user.setId("sfjsoop1jsjisf_1");
        user.setUsername("lazycece");
        user.setName("W");
        user.setAge(200);
        return user;
    }
}
