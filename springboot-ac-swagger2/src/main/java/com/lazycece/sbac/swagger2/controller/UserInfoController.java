package com.lazycece.sbac.swagger2.controller;

import com.lazycece.sbac.swagger2.controller.req.UserInfoReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author lazycece
 * @date 2019/1/31
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Api(tags = "用户管理")
public class UserInfoController {

    @PutMapping("/add")
    @ApiOperation(value = "添加用户")
    public Object add(UserInfoReq req) {
        log.info("添加用户成功: {}", req.toString());
        return "success";
    }

    @DeleteMapping("/{username}/delete")
    @ApiOperation(value = "删除用户", notes = "根据用户名删除用户")
    @ApiImplicitParam(name = "username", value = "用户名", required = true)
    public Object delete(@PathVariable(value = "username") String username) {
        log.info("删除用户 {} 成功", username);
        return "success";
    }

    @GetMapping("/query")
    @ApiOperation(value = "查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名"),
            @ApiImplicitParam(name = "sex", value = "性别", allowableValues = "0,1,2")
    })
    public Object query(String username, String sex) {
        UserInfoReq user = new UserInfoReq();
        user.setUsername(username);
        user.setPassword("******");
        user.setAge(18);
        user.setSex(sex);
        return user;
    }

    @PostMapping("/{username}/update")
    @ApiOperation(value = "更新用户信息", notes = "根据用户名更新用户信息")
    @ApiImplicitParam(name = "username", value = "用户名", required = true)
    public Object update(@PathVariable String username) {
        log.info("更新用户信息 {} 成功", username);
        return "success";
    }
}
